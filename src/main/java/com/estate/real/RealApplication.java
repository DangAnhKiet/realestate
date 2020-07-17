package com.estate.real;

import com.estate.real.config.ContractInfo;
import com.estate.real.contract.ManageRealEsate;
import com.estate.real.utils.MyFile;
import com.estate.real.utils.MyWeb3j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class RealApplication {
    private static boolean isDeploySmartContract = false;
    private static boolean runContractReceive = false;
    private static boolean runContractSend = false;
    private static boolean runManageRealEstae = false;

    public static void main(String[] args) {
        int check = 1;
        if (isDeploySmartContract) {
            if (runContractReceive) {
                if (MyWeb3j.runDeploySmartContract(MyWeb3j.CONTRACT_RECEIVE, MyFile.ADDRESS_CONTRACT_RECEIVE)) {
                    check *= 1;
                } else {
                    check *= 0;
                    System.out.println("Deploy that bai "+MyWeb3j.CONTRACT_RECEIVE);
                }
            }
            if (runContractSend) {
                if (MyWeb3j.runDeploySmartContract(MyWeb3j.CONTRACT_SEND, MyFile.ADDRESS_CONTRACT_SEND)) {
                   check *= 1;
                } else {
                    check *= 0;
                    System.out.println("Deploy that bai "+MyWeb3j.CONTRACT_SEND);
                }
            }
            if (runManageRealEstae) {
                if (MyWeb3j.runDeploySmartContract(MyWeb3j.CONTRACT_MANAGE_REAL_ESTATE, MyFile.ADDRESS_CONTRACT_FILE)) {
                   check *= 1;
                } else {
                    check *= 0;
                    System.out.println("Deploy that bai "+MyWeb3j.CONTRACT_MANAGE_REAL_ESTATE);
                }
            }
            if(check == 1) {
                SpringApplication.run(RealApplication.class, args);
            }
        }else{
            SpringApplication.run(RealApplication.class, args);
        }
    }
}
