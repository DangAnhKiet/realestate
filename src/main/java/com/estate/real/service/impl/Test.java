package com.estate.real.service.impl;

import com.estate.real.config.ContractInfo;
import com.estate.real.utils.MyFile;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;
import org.web3j.utils.Numeric;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {

        System.out.println("Connecting to Ethereum ...");
        Web3j web3 = Web3j.build(new HttpService(ContractInfo.locationEthereum));
        System.out.println("Successfuly connected to Ethereum");

        try {

            // Decrypt and open the wallet into a Credential object
            Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
            System.out.println("Account address: " + credentials.getAddress());
            System.out.println("Balance: " + Convert.fromWei(web3.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send().getBalance().toString(), Unit.ETHER));

            // Get the latest nonce
            EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
            BigInteger nonce = ethGetTransactionCount.getTransactionCount();

            // Recipient address
//            String recipientAddress = "0x0766FaA541B484De87dbFEce64fb206e8601B450";
            String recipientAddress = MyFile.RealFromFile(MyFile.ADDRESS_CONTRACT_FILE);
            System.out.println("dia chi contract: "+recipientAddress);
            // Value to transfer (in wei)
            BigInteger value = Convert.toWei("1", Unit.ETHER).toBigInteger();

            // Gas Parameters
            BigInteger gasLimit = BigInteger.valueOf(21000);
            BigInteger gasPrice = Convert.toWei("1", Unit.GWEI).toBigInteger();


            // Prepare the rawTransaction
            RawTransaction rawTransaction = RawTransaction.createEtherTransaction(
                    nonce,
                    gasPrice,
                    gasLimit,
                    recipientAddress,
                    value);

            // Sign the transaction
            byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
            String hexValue = Numeric.toHexString(signedMessage);

            // Send transaction
            EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).send();
            String transactionHash = ethSendTransaction.getTransactionHash();
            System.out.println("transactionHash: " + transactionHash);

            // Wait for transaction to be mined
            Optional<TransactionReceipt> transactionReceipt = null;
            do {
                System.out.println("checking if transaction " + transactionHash + " is mined....");
                EthGetTransactionReceipt ethGetTransactionReceiptResp = web3.ethGetTransactionReceipt(transactionHash).send();
                transactionReceipt = ethGetTransactionReceiptResp.getTransactionReceipt();
                Thread.sleep(3000); // Wait 3 sec
            } while (!transactionReceipt.isPresent());

            System.out.println("Gas limit: "+ gasLimit);
            System.out.println("Gas price: "+ gasPrice);

            System.out.println("Transaction " + transactionHash + " was mined in block # " + transactionReceipt.get().getBlockNumber());
            System.out.println("Balance: " + Convert.fromWei(web3.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send().getBalance().toString(), Unit.ETHER));


        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
