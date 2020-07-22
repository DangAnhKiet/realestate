//package com.estate.real.service.impl;
//
//import com.estate.real.config.ContractInfo;
//import com.estate.real.contract.ContractReceive;
//import com.estate.real.utils.MyFile;
//import com.estate.real.utils.MyWeb3j;
//import org.web3j.crypto.CipherException;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.http.HttpService;
//import org.web3j.utils.Convert;
//
//import java.io.IOException;
//import java.math.BigInteger;
//import java.security.InvalidAlgorithmParameterException;
//import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//
//public class democontract {
//    public static void main(String[] args) throws IOException, CipherException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
//        Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
//        try {
//            ContractReceive contractReceive = ContractReceive.load(MyFile.RealFromFile(MyFile.ADDRESS_CONTRACT_RECEIVE),
//                    web3j, MyWeb3j.credentials, MyWeb3j.gasPrice, MyWeb3j.gasLimit);
//            BigInteger ethCurr = contractReceive.getEthReceive().send();
//            System.out.println("So eth contract nhan duoc: " + Convert.toWei(ethCurr.toString(), Convert.Unit.WEI));
//
////            ContractSend contractSend = ContractSend.load(MyFile.RealFromFile(MyFile.ADDRESS_CONTRACT_SEND),
////                    web3j,MyWeb3j.credentials, MyWeb3j.gasPriceTransfer, MyWeb3j.gasLimitTransfer);
////            contractSend.sendEth(MyFile.RealFromFile(MyFile.ADDRESS_CONTRACT_RECEIVE),Convert.toWei("1", Convert.Unit.ETHER).toBigInteger()).send();
//        } catch (Exception e) {
////            System.out.println("Loi deploy smart contract");
////            System.out.println("Loi deploy smart contract");
//            e.printStackTrace(System.out);
//        }
//    }
//}
