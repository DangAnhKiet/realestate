package com.estate.real.service.impl;

import com.estate.real.config.ContractInfo;
import com.estate.real.contract.ContractReceive;
import com.estate.real.contract.ManageRealEsate;
import com.estate.real.utils.MyFile;
import com.estate.real.utils.MyWeb3j;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

public class democontract {
    public static void main(String[] args) throws IOException, CipherException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
        try {
            Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
//            Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
            Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
            String addressContract = MyFile.RealFromFile(MyFile.ADDRESS_CONTRACT_FILE);
            BigInteger gasLimit = BigInteger.valueOf(672197500);
            BigInteger gasPrice =
                    Convert.toWei("2000000", Convert.Unit.WEI).toBigInteger();
            ManageRealEsate manageRealEsate = ManageRealEsate.load(addressContract, web3j, credentials,
                    gasLimit, gasPrice);


//            System.out.println(receiptAdd.isStatusOK());
            String address1 = "0xe474937df3638Fb46eE7B8627C31d2D5b17FE4a1";
            String addressC = "0xDBfCcaC6719DEc03C1560867Df89F97025C62076";
//            TransactionReceipt receiptAdd =  manageRealEsate.addLand(addressC,"quan1","duong1","img1","gia1","phuong1","mota1").send();
//            manageRealEsate
//                    .addEventObservable(DefaultBlockParameterName.LATEST, DefaultBlockParameterName.LATEST)
//                    .subscribe(event -> {
//                        final int landId = Integer.valueOf(event._landID.toString());
//                        final String addressOwner = event._owner.toString();
//                        System.out.println(" landid vua moi add vao blockchain: " + landId);
//                        System.out.println(" address chu dat moi add: " + addressOwner);
////                        land.setLandId(landId);
//                    });
            System.out.println("sfdfsd");
//            event Transfer(address indexed _from, address indexed _to, uint _landId);
//            function transferLand(address _landBuyer,address _ownerLand, uint _landID)
//            TransactionReceipt receiptTransfer =  manageRealEsate.transferLand(address1,addressC,BigInteger.valueOf(1)).send();
//            if(receiptTransfer.isStatusOK()){
//                manageRealEsate
//                        .transferEventObservable(DefaultBlockParameterName.LATEST, DefaultBlockParameterName.LATEST)
//                        .subscribe(event -> {
//                            final String transferFrom = event._from;
//                            final String transferTo = event._to;
//                            final int landId = Integer.valueOf(event._landId.toString());
//                            System.out.println(" dia chi nguoi ban: " + transferFrom);
//                            System.out.println(" dia chi nguoi mua: " + transferTo);
//                            System.out.println(" id cua dat: " + landId);
////                        land.setLandId(landId);
//                        });
//            }

//            String addressDeploy = "0xc29E3EC8C74638d1979b6f72762E4C7d944Fc530";
////            System.out.println("so land: "+manageRealEsate.getNoOfLand(addressC).send());;
//            EthAccounts listAccount = new EthAccounts();
//            listAccount = web3j.ethAccounts().sendAsync().get() ;
//            List<String> stringListAccount = listAccount.getAccounts();
//            for (String i : stringListAccount){
//                BigInteger size = manageRealEsate.getNoOfLand(i).send();
//                int intSize = size.intValue();
//                System.out.println("+++++++++++++++++++++++++++++++++++Danh sach dat cua accout: "+i);
//                for(int j = 0; j < intSize; j++){
//                    Tuple8<String, String, String, String, String, String, String, BigInteger> landTupble = manageRealEsate.getLandByAddress(i,
//                    BigInteger.valueOf(j)).send();
//                    System.out.println(landTupble.getValue1());
//                    System.out.println(landTupble.getValue2());
//                    System.out.println(landTupble.getValue3());
//                    System.out.println(landTupble.getValue4());
//                    System.out.println(landTupble.getValue5());
//                    System.out.println(landTupble.getValue6());
//                    System.out.println(landTupble.getValue7());
//                    System.out.println(landTupble.getValue8());
//                }
//            }


////            GET HISTORY OF LAND
            BigInteger landIdCurrent = BigInteger.valueOf(1);
            BigInteger sizeArrayLandCurrent = manageRealEsate.getNoOfHistory(landIdCurrent).send();
            System.out.println("+++++++++++++++++++++++++++++++++++Danh sach LICH SU GIAO DICH CUA LANDID: ");
            for (int i = 0; i < sizeArrayLandCurrent.intValue(); i++){
                Tuple5<String, String, String, String, String> historyList = manageRealEsate.getHistoryByLandId(landIdCurrent,
                        BigInteger.valueOf(i)).send();
                System.out.println(historyList.getValue1());//dia chi nguoi mua
                System.out.println(historyList.getValue2());//dia chi nguoi ban
                System.out.println(historyList.getValue3());//gia ban
                System.out.println(historyList.getValue4());//ngay bans
                System.out.println(historyList.getValue5());//hinh anh
            }


//            Tuple8<String, String, String, String, String, String, String, BigInteger> landTupble = manageRealEsate.getLandByAddress(addressC,
//                    BigInteger.valueOf(0)).send();
            System.out.println("sfsdf");
//
//
//            EthGetBalance balanceResult = web3j.ethGetBalance("0xe474937df3638Fb46eE7B8627C31d2D5b17FE4a1",DefaultBlockParameterName.LATEST).send();
//            BigInteger balanceInWei = balanceResult.getBalance();
//            System.out.println(Convert.toWei(new BigDecimal(balanceInWei), Convert.Unit.WEI));
//            System.out.println(balanceInWei.toString());
//            if(balanceInWei.toString().length() >= 18){
//                System.out.println(balanceInWei.toString().substring(0,balanceInWei.toString().length() - 18));
//            }
        } catch (Exception e) {
//            System.out.println("Loi deploy smart contract");
//            System.out.println("Loi deploy smart contract");
            e.printStackTrace(System.out);
        }
    }
}
