package com.estate.real.utils;

import com.estate.real.config.ContractInfo;
import com.estate.real.contract.ManageRealEsate;
import org.web3j.abi.datatypes.Function;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigInteger;

public class MyWeb3j {
//    the value of ganache
//    GAS LIMIT : 6721975
//    GAS PRICE 20000000000
    public static Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
    public static Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
    //3.Configure gas parameters
//    public static BigInteger gasLimit = BigInteger.valueOf(21000);
    public static BigInteger gasLimit = BigInteger.valueOf(672197500);
    public static BigInteger gasPrice =
            Convert.toWei("2000000", Convert.Unit.WEI).toBigInteger();
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

    public static  boolean runDeploySmartContract(){
        if(true){
            Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
            Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
            //3.Configure gas parameters
//            BigInteger gasLimit = BigInteger.valueOf(672197500);
//            BigInteger gasPrice =
//                    Convert.toWei("1", Convert.Unit.GWEI).toBigInteger();
            try{
                ManageRealEsate manageRealEsate = ManageRealEsate.deploy(web3j, credentials, gasPrice, gasLimit).send();
                if(manageRealEsate.isValid()){
                    MyFile.CreateNewFile(MyFile.ADDRESS_CONTRACT_FILE);
                    MyFile.WriteToFile(MyFile.ADDRESS_CONTRACT_FILE, manageRealEsate.getContractAddress());
                    System.out.println("Deploy smart contract thanh cong");
                    return true;
                }else{
                    MyFile.CreateNewFile(MyFile.ADDRESS_CONTRACT_FILE);
                    MyFile.WriteToFile(MyFile.ADDRESS_CONTRACT_FILE, "0x0000");
                    System.out.println("Deploy smart contract that bai");
                }
            }catch(Exception e){
                System.out.println("Loi deploy smart contract to ethereum");
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
