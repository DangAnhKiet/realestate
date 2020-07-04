package com.estate.real.utils;

import com.estate.real.config.ContractInfo;
import com.estate.real.contract.ManageRealEsate;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigInteger;

public class MyWeb3j {
    public static Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
    public static Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
    //3.Configure gas parameters
    public static BigInteger gasLimit = BigInteger.valueOf(672197500);
    public static BigInteger gasPrice =
            Convert.toWei("1", Convert.Unit.GWEI).toBigInteger();
    public static String addressContract = MyFile.RealFromFile(MyFile.ADDRESS_CONTRACT_FILE);
    public static ManageRealEsate LoadSmartContract(){
        try{
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
}
