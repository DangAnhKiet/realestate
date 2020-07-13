package com.estate.real.service.impl;

import com.estate.real.config.ContractInfo;
import com.estate.real.contract.ManageRealEsate;
import com.estate.real.utils.MyWeb3j;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Optional;

public class democontract {
    public static void main(String[] args) throws IOException, CipherException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
        Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
//        Credentials credentials = Credentials.create("0x62F5a8222c1c63587dfb84be589526Df2AB81E9a");
//        Credentials credentials = WalletUtils.loadBip39Credentials("password", "mnemonic");
        Credentials credentials = Credentials.create("a4438682c7cf0d82406c380953e88c3a27fc2cacea2c29d7c656fcc855b1035a");
        String addressChuDat = "0x62F5a8222c1c63587dfb84be589526Df2AB81E9a";
        String buyerAddress = "0xe474937df3638Fb46eE7B8627C31d2D5b17FE4a1";
        try {

// Get nonce
                EthGetTransactionCount ethGetTransactionCount = MyWeb3j.web3j.ethGetTransactionCount(MyWeb3j.credentials.getAddress(),
                        DefaultBlockParameterName.LATEST).send();
                BigInteger nonce = ethGetTransactionCount.getTransactionCount();

                RawTransaction rawTransaction = RawTransaction.createEtherTransaction(
                        nonce,
                        MyWeb3j.gasPrice,
                        MyWeb3j.gasLimit,
                        MyWeb3j.recipientAddress,
                        MyWeb3j.value);
                // Sign the transaction
                byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, MyWeb3j.credentials);

// Convert it to Hexadecimal String to be sent to the node
                String hexValue = Numeric.toHexString(signedMessage);

                // Send transaction
                EthSendTransaction ethSendTransaction = MyWeb3j.web3j.ethSendRawTransaction(hexValue).send();
                String transactionHash = ethSendTransaction.getTransactionHash();
                System.out.println("transactionHash: " + transactionHash);
                // Wait for transaction to be mined
//                Optional<TransactionReceipt> transactionReceipt = null;
//                do {
//                    System.out.println("checking if transaction " + transactionHash + " is mined....");
//                    EthGetTransactionReceipt ethGetTransactionReceiptResp = MyWeb3j.web3j.ethGetTransactionReceipt(transactionHash).send();
//                    transactionReceipt = ethGetTransactionReceiptResp.getTransactionReceipt();
//                    Thread.sleep(3000); // Wait 3 sec
//                } while(!transactionReceipt.isPresent());

//                System.out.println("Transaction " + transactionHash + " was mined in block # " + transactionReceipt.get().getBlockNumber());
//                System.out.println("Balance: " + Convert.fromWei(MyWeb3j.web3j.ethGetBalance(MyWeb3j.credentials.getAddress(),
//                        DefaultBlockParameterName.LATEST).send().getBalance().toString(), Convert.Unit.ETHER));
        } catch (Exception e) {
//            System.out.println("Loi deploy smart contract");
            System.out.println("Loi deploy smart contract");
            e.printStackTrace(System.out);
        }
    }
}
