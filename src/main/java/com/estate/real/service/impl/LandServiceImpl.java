package com.estate.real.service.impl;

import com.estate.real.Repository.inf.LandRepository;
import com.estate.real.config.ContractInfo;
import com.estate.real.document.Land;
import com.estate.real.model.request.LandRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.service.inf.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigInteger;

@Service
public class LandServiceImpl implements LandService {

    @Autowired
    LandRepository landRepository;

    @Override
    public GeneralResponse addLand(LandRequest request) {
        Land land = new Land();
        land.setAddressSeller(request.getAddressSeller());
        land.setDistrict(request.getDistrict());
        land.setImage(request.getImage());
        land.setPrice(request.getPrice());
        land.setStreet(request.getStreet());

        //Thêm đất và ethereum
        Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
        Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
        //3.Configure gas parameters
        BigInteger gasLimit = BigInteger.valueOf(672197500);
        BigInteger gasPrice =
                Convert.toWei("1", Convert.Unit.GWEI).toBigInteger();
        try {
//            ManageRealEsate manageRealEsate = ManageRealEsate.deploy(web3j, credentials, gasPrice, gasLimit).send();
//            System.out.println("Smart contract address: "+manageRealEsate.getContractAddress());

            ManageRealEsate manageRealEsate = ManageRealEsate.load(ContractInfo.addressContract, web3j, credentials,
                    gasLimit, gasPrice);
//
            TransactionReceipt transactionReceipt = manageRealEsate.addLand("Quan 1", "Tran hung dao",
                    BigInteger.valueOf(1000000000)).send();
            System.out.println("add status: " + transactionReceipt.isStatusOK());
        } catch (Exception e) {
//            System.out.println("Loi deploy smart contract");
            e.printStackTrace(System.out);
        }
        //Thêm đất vào database khi thêm vào etherum thành công
        landRepository.save(land);
        return new GeneralResponse(true);
    }
}
