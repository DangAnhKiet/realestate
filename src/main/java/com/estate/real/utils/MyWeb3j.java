package com.estate.real.utils;

import com.estate.real.config.ContractInfo;
//import com.estate.real.contract.ContractReceive;
//import com.estate.real.contract.ContractSend;
import com.estate.real.contract.ManageRealEsate;
import org.web3j.abi.datatypes.Function;
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
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.Optional;

public class MyWeb3j {
//    the value of ganache
//    GAS LIMIT : 6721975
//    GAS PRICE 20000000000
    public static final String CONTRACT_RECEIVE = "ContractReceive";
    public static final String CONTRACT_SEND = "ContractSend";
    public static final String CONTRACT_MANAGE_REAL_ESTATE = "ManageRealEsate";

    public static Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
    public static Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
    //3.Configure gas parameters
    public static BigInteger gasLimitTransfer = BigInteger.valueOf(6721975);
    public static BigInteger gasPriceTransfer = Convert.toWei("1", Convert.Unit.GWEI).toBigInteger();

    public static BigInteger gasLimitDeploy = BigInteger.valueOf(6721975);
    public static BigInteger gasLimit = BigInteger.valueOf(672197500);
    public static BigInteger gasPrice =
            Convert.toWei("2000000", Convert.Unit.WEI).toBigInteger();
    public static BigInteger gasPriceDeploy =
            Convert.toWei("2", Convert.Unit.WEI).toBigInteger();
    public static String addressContract = MyFile.RealFromFile(MyFile.ADDRESS_CONTRACT_FILE);
    // Value to transfer (in wei)
    public static BigInteger value = Convert.toWei("1", Convert.Unit.ETHER).toBigInteger();
    // Recipient address
    public static String recipientAddress = "0x0766FaA541B484De87dbFEce64fb206e8601B450";
    public static ManageRealEsate LoadSmartContract(){
        try{
            System.out.println("gas limit: "+MyWeb3j.gasLimit);
            System.out.println("gas price: "+MyWeb3j.gasPrice);
            ManageRealEsate manageRealEsate = ManageRealEsate.load(addressContract, web3j, credentials,
                    gasLimit, gasPrice);
            if(manageRealEsate.isValid()){
                return manageRealEsate;
            }else{
                System.out.println("Loi load smart contract trong ham LoadSmartContract");
                return null;
            }
        }catch(Exception e){
            System.out.println("Loi Load smart contract trong catch");
            e.printStackTrace();
            return null;
        }
    }

    public static  boolean runDeploySmartContract(String classNameWrap, String addressContractTXT){
        if(true){
            Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
            Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
            //3.Configure gas parameters
//            BigInteger gasLimit = BigInteger.valueOf(672197500);
//            BigInteger gasPrice =
//                    Convert.toWei("1", Convert.Unit.GWEI).toBigInteger();
            try{
                switch (classNameWrap){
                    case MyWeb3j.CONTRACT_MANAGE_REAL_ESTATE:
                        ManageRealEsate manageRealEsate = ManageRealEsate.deploy(web3j, credentials, gasPriceDeploy, gasLimitDeploy).send();
                        if(manageRealEsate.isValid()){
                            MyFile.CreateNewFile(addressContractTXT);
                            MyFile.WriteToFile(addressContractTXT, manageRealEsate.getContractAddress());
                            System.out.println("Deploy smart contract thanh cong");
                            return true;
                        }else{
                            MyFile.CreateNewFile(addressContractTXT);
                            MyFile.WriteToFile(addressContractTXT, "0x0000");
                            System.out.println("Deploy smart contract that bai");
                        }
                        break;
//                    case MyWeb3j.CONTRACT_RECEIVE:
//                        ContractReceive contractReceive = ContractReceive.deploy(web3j, credentials, gasPriceDeploy, gasLimitDeploy).send();
//                        if(contractReceive.isValid()){
//                            MyFile.CreateNewFile(addressContractTXT);
//                            MyFile.WriteToFile(addressContractTXT, contractReceive.getContractAddress());
//                            System.out.println("Deploy smart contract thanh cong");
//                            return true;
//                        }else{
//                            MyFile.CreateNewFile(addressContractTXT);
//                            MyFile.WriteToFile(addressContractTXT, "0x0000");
//                            System.out.println("Deploy smart contract that bai");
//                        }
//                        break;
//                    case MyWeb3j.CONTRACT_SEND:
//                        ContractSend contractSend = ContractSend.deploy(web3j, credentials, gasPriceDeploy, gasLimitDeploy).send();
//                        if(contractSend.isValid()){
//                            MyFile.CreateNewFile(addressContractTXT);
//                            MyFile.WriteToFile(addressContractTXT, contractSend.getContractAddress());
//                            System.out.println("Deploy smart contract thanh cong");
//                            return true;
//                        }else{
//                            MyFile.CreateNewFile(addressContractTXT);
//                            MyFile.WriteToFile(addressContractTXT, "0x0000");
//                            System.out.println("Deploy smart contract that bai");
//                        }
//                        break;
                }

            }catch(Exception e){
                System.out.println("Loi deploy smart contract to ethereum");
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean transferEth(String priKey, Web3j web3,String recipientAddress, String strETH){
        boolean result = false;
        try{
            Credentials credentials = Credentials.create(priKey);
            EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
            BigInteger nonce = ethGetTransactionCount.getTransactionCount();
            BigInteger valueEth = Convert.toWei(strETH, Convert.Unit.ETHER).toBigInteger();

            // Gas Parameters
            BigInteger gasLimit = BigInteger.valueOf(21000);
            BigInteger gasPrice = Convert.toWei("1", Convert.Unit.GWEI).toBigInteger();
            // Prepare the rawTransaction
            RawTransaction rawTransaction = RawTransaction.createEtherTransaction(
                    nonce,
                    gasPrice,
                    gasLimit,
                    recipientAddress,
                    valueEth);
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
            System.out.println("Transaction " + transactionHash + " was mined in block # " + transactionReceipt.get().getBlockNumber());
            System.out.println("Balance: " + Convert.fromWei(web3.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send().getBalance().toString(), Convert.Unit.ETHER));
            result = true;


        }catch (Exception e){
            System.out.println("Loi transfer");
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public static String getAddress(String privateKey){
        String result = "";
        Credentials credentials = Credentials.create(privateKey);
        if( null != credentials.getAddress()){
            result = credentials.getAddress();
        }
        return result;
    }

    public static void main(String[] args) {
        MyWeb3j myWeb3j = new MyWeb3j();
        System.out.println("test transfer: "+myWeb3j.transferEth("7195f2222778b16310d531f2dc3c1f5c438aef04ff09383367bb4c77a268a249",
                MyWeb3j.web3j,"0xDBfCcaC6719DEc03C1560867Df89F97025C62076","15"));
    }
}
