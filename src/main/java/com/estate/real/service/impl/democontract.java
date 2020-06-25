package com.estate.real.service.impl;

import com.estate.real.config.ContractInfo;
import com.estate.real.contract.ManageRealEsate;
import org.springframework.http.server.reactive.JettyHttpHandlerAdapter;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.math.BigInteger;

public class democontract {
    public static void main(String[] args) {
        Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
        Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
        //3.Configure gas parameters
        BigInteger gasLimit = BigInteger.valueOf(672197885);

        BigInteger gasPrice = Convert.toWei("0.0000000000000000000000000001", Convert.Unit.GWEI).toBigInteger();
        try {
//            ManageRealEsate manageRealEsate = ManageRealEsate.deploy(web3j, credentials, gasPrice, gasLimit).send();
//            System.out.println("Smart contract address: "+manageRealEsate.getContractAddress());

            ManageRealEsate manageRealEsate = ManageRealEsate.load(ContractInfo.addressContract, web3j, credentials,
                    gasLimit, gasPrice);

            TransactionReceipt transactionReceipt = manageRealEsate.addLand("Quan 1", "Tran dudf",
                    BigInteger.valueOf(1000000)).send();
            System.out.println("add status: " + transactionReceipt.isStatusOK());
        } catch (Exception e) {
//            System.out.println("Loi deploy smart contract");
            e.printStackTrace(System.out);
        }
    }


//        try
//
//    {
//            Web3ClientVersion clientVersion = web3.web3ClientVersion().send();
//            EthBlockNumber blockNumber = web3.ethBlockNumber().send();
//            EthGasPrice gasPrice = web3.ethGasPrice().send();
//            EthGetBalance getBalanceWei = web3.ethGetBalance("0x89E8416eA5b69863CCb34D3A5C74A86bf5549147", DefaultBlockParameterName.LATEST).send();
////            EthGetBalance getBalanceWei = web3.ethGetBalance("0x89E8416eA5b69863CCb34D3A5C74A86bf5549147",new DefaultBlockParameterNumber(3000000)).send();
//            System.out.println("balance in wei: "+getBalanceWei);
//            BigDecimal getBalanceEther = Convert.fromWei(getBalanceWei.getBalance().toString(), Convert.Unit.ETHER);
//            System.out.println("balance in ether: "+getBalanceEther);
//            EthGetTransactionCount getTransactionCount = web3.ethGetTransactionCount("0x89E8416eA5b69863CCb34D3A5C74A86bf5549147", DefaultBlockParameterName.LATEST).send();
//            System.out.println("Transaction count: "+ getTransactionCount.getTransactionCount());
//            System.out.println("Client version: "+clientVersion.getWeb3ClientVersion());
//            System.out.println("Gas price: "+gasPrice.getGasPrice());
//            System.out.println("Block number: "+blockNumber.getBlockNumber());

    //Load a wallet

    //Send funds from one account to another
    //1. Get none:
//        EthGetTransactionCount getTransactionCount = web3.ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
//        BigInteger nonce = getTransactionCount.getTransactionCount();
//        System.out.println("nonce: "+nonce);
    //2.Configure recipient account and amount to send
//        String recipientAddress = "0x89E8416eA5b69863CCb34D3A5C74A86bf5549147";
//        BigInteger valueToTranfer = Convert.toWei("1", Convert.Unit.ETHER).toBigInteger();
//        System.out.println(valueToTranfer);
    //3.Configure gas parameters
//        BigInteger gasLimit = BigInteger.valueOf(21000);
//        BigInteger gasPrice = Convert.toWei("1", Convert.Unit.GWEI).toBigInteger();
//        System.out.println("gasPrice: " + gasPrice);
    //Prepare a rew transaction
//        RawTransaction rawTransaction = RawTransaction.createEtherTransaction(
//                nonce,
//                gasPrice,
//                gasLimit,
//                recipientAddress,
//                valueToTranfer
//        );
    //Sign the transaction
//        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
//        System.out.println("byte[] signedMessage: " + signedMessage.toString());
//        //Convert it to Hexadecimal String to be send to the node
//        String hexValue  = Numeric.toHexString(signedMessage);
//        System.out.println("hexValue: "+ hexValue);

    //Send to the node via JSON RPC.
//        EthSendTransaction ethSendTransaction= web3.ethSendRawTransaction(hexValue).send();
    //Get the transaction hash
//        String transactionHash = ethSendTransaction.getTransactionHash();
//        System.out.println("Transaction hash: " + transactionHash);
// Wait for transaction to be mined
//        Optional<TransactionReceipt> transactionReceipt = null;
//    }catch(
//    Exception e)
//
//    {
//        e.printStackTrace();
//    }

}
