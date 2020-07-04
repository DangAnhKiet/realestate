package com.estate.real;

import com.estate.real.config.ContractInfo;
import com.estate.real.contract.ManageRealEsate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigInteger;

@SpringBootApplication
public class RealApplication {
    private static boolean isDeploySmartContract = false;

    public static void main(String[] args) {
        if(isDeploySmartContract){
            if(ContractInfo.runDeploySmartContract()){
                SpringApplication.run(RealApplication.class, args);
            }else{
                System.out.println("Deploy that bai khong the chay ung dung spring boot");
            }
        }else{
            SpringApplication.run(RealApplication.class, args);
        }
    }



}
