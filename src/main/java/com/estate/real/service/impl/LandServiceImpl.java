package com.estate.real.service.impl;

import com.estate.real.Repository.inf.LandRepository;
import com.estate.real.config.ContractInfo;
import com.estate.real.contract.ManageRealEsate;
import com.estate.real.document.Land;
import com.estate.real.model.enums.LandStatus;
import com.estate.real.model.request.LandPagingRequest;
import com.estate.real.model.request.LandRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.model.response.LandResponse;
import com.estate.real.service.inf.LandService;
import com.estate.real.utils.MyWeb3j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        land.setStatus(LandStatus.active.ordinal());
        //Mac dinh gan landId = -1,trong trường hợp không thể get from ethereum
        land.setLandId(-1);

        //Thêm đất vào ethereum
        try {
            ManageRealEsate manageRealEsate = MyWeb3j.LoadSmartContract();
            if (manageRealEsate != null) {
                TransactionReceipt transactionReceipt = manageRealEsate.addLand(land.getDistrict(), land.getStreet(),
                        land.getImage(), land.getPrice(), BigInteger.valueOf(land.getStatus())).send();
                System.out.println("Trạng thái của quá trình thêm land vào blockchain: " + transactionReceipt.isStatusOK());
                if (transactionReceipt.isStatusOK()) {
                    //Get event để thêm landId vào db
                    manageRealEsate
                            .addEventObservable(DefaultBlockParameterName.LATEST, DefaultBlockParameterName.LATEST)
                            .subscribe(event -> {
                                final int landId = Integer.valueOf(event._landID.toString());
                                System.out.println(" landid vua moi add vao blockchain: " + landId);
                                land.setLandId(landId);
                            });
                    //Them land vao database
                    landRepository.save(land);
                    return new GeneralResponse(true);
                } else {
                    System.out.println("Qua trinh them land vao blockchain THAT BAI. Khong them vao database");
                    return new GeneralResponse(false);
                }
            }
        } catch (Exception e) {
            System.out.println("Loi deploy smart contract");
            e.printStackTrace(System.out);
        }
        return new GeneralResponse(false);
    }

    @Override
    public List<LandResponse> getLandPaging(LandPagingRequest request) {
        List<Land> lands = landRepository.getLandPaging(request);
        List<LandResponse> landResponses = new ArrayList<>();
        if (lands != null) {
            return lands.stream().map(LandResponse::new).collect(Collectors.toList());
        }
        return landResponses;
    }

    @Override
    public List<LandResponse> getAllLand() {
        List<Land> lands = landRepository.getAllLands();
        List<LandResponse> landResponses = new ArrayList<>();
        if (lands != null) {
            return lands.stream().map(LandResponse::new).collect(Collectors.toList());
        }
        return landResponses;
    }
}
