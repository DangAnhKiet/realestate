package com.estate.real.config;

import com.estate.real.contract.ManageRealEsate;
import com.estate.real.utils.MyFile;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigInteger;

public class ContractInfo {
    public static final String pkDeploy = "494112cab9ea77233e3259d5a016a265aae9a8006d1e94c109823962ec7df677";
    public static final String locationEthereum = "HTTP://127.0.0.1:7545";
//    public static final String addressContract = "0x89E8416eA5b69863CCb34D3A5Csfsdfsdf74A86bf5549147";

    public static  boolean runDeploySmartContract(){
        if(true){
            Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
            Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
            //3.Configure gas parameters
            BigInteger gasLimit = BigInteger.valueOf(672197500);
            BigInteger gasPrice =
                    Convert.toWei("1", Convert.Unit.GWEI).toBigInteger();
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
                return false;
            }
        }
        return false;
    }
}
