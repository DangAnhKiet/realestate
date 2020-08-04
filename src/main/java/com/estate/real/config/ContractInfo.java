package com.estate.real.config;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.http.HttpService;

import java.util.List;

public class ContractInfo {
    public static final String pkDeploy = "841de285cf6b841cb7d7f8c9aefd184d78063fe7e72f739a0807c0f758d19e8f";
    public static final String locationEthereum = "HTTP://127.0.0.1:7545";
//    public static finLoi load smart contract trong ham LoadSmartContractal String addressContract = "0x89E8416eA5b69863CCb34D3A5Csfsdfsdf74A86bf5549147";

    public static String getPrivateDeploy(){
        try {
            Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
            EthAccounts listAccount = new EthAccounts();
            listAccount = web3j.ethAccounts().sendAsync().get() ;
            return  listAccount.getAccounts().get(0);
        }catch (Exception e){
            e.printStackTrace();
            return "0x000";
        }
    }
}
