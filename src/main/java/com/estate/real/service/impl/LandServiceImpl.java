package com.estate.real.service.impl;

import com.estate.real.Repository.inf.AccountRepository;
import com.estate.real.Repository.inf.LandRepository;
import com.estate.real.config.ContractInfo;
import com.estate.real.contract.ManageRealEsate;
import com.estate.real.document.Account;
import com.estate.real.document.Land;
import com.estate.real.model.enums.AccountStatus;
import com.estate.real.model.enums.LandStatus;
import com.estate.real.model.request.LandFilterRequest;
import com.estate.real.model.request.LandPagingRequest;
import com.estate.real.model.request.LandRequest;
import com.estate.real.model.request.TransactionRequest;
import com.estate.real.model.response.AccountResponse;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.model.response.LandResponse;
import com.estate.real.service.inf.AccountService;
import com.estate.real.service.inf.LandService;
import com.estate.real.utils.CurrencyConverter;
import com.estate.real.utils.MyDate;
import com.estate.real.utils.MyFile;
import com.estate.real.utils.MyWeb3j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LandServiceImpl implements LandService {

    @Autowired
    LandRepository landRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public GeneralResponse addLand(LandRequest request) {
        Land land = new Land();
        land.setAddressHolder(request.getAddressSeller());
        land.setDistrict(request.getDistrict());
        land.setPathImage(request.getPathImage());
        land.setPrice(request.getPrice());
        land.setStreet(request.getStreet());
        land.setStatus(LandStatus.active.toString());
        land.setWard(request.getWard());
        land.setDescription(request.getDescription());
        land.setCreatedBy("admin");
        land.setCreatedDate(MyDate.getNow());
        //Mac dinh gan landId = -1,trong trường hợp không thể get from ethereum
        land.setLandId(-1);

        //Thêm đất vào ethereum
        try {
            ManageRealEsate manageRealEsate = MyWeb3j.LoadSmartContract();
            if (manageRealEsate != null) {
                TransactionReceipt transactionReceipt = manageRealEsate.addLand(land.getDistrict(), land.getStreet(),
                        land.getPathImage(), land.getPrice(), land.getWard(), land.getDescription()).send();
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

    @Override
    public List<LandResponse> getFilterLand(LandFilterRequest request) {
        List<Land> lands = landRepository.getFilterLand(request);
        List<LandResponse> landResponses = new ArrayList<>();
        if (lands != null) {
            return lands.stream().map(LandResponse::new).collect(Collectors.toList());
        }
        return landResponses;
    }

    @Override
    public List<Land> getAllLandByAddressHolder(String addressHolder) {
        Account account = accountRepository.findByAddress(addressHolder);
        if (account == null) {
            return null;
        }
        return landRepository.getAllByAddressHolder(addressHolder);
    }

    @Override
    public LandResponse getLandById(int idLand) {
        Land landNative = landRepository.getByLandId(idLand, LandStatus.active.toString());
        if (landNative != null) {
            LandResponse landResponse = new LandResponse(landNative);
            landResponse.setAddressSeller(landNative.getAddressHolder());
            landResponse.setDescription(landNative.getDescription());
            landResponse.setDistrict(landNative.getDistrict());
            landResponse.setImage(landNative.getPathImage());
            landResponse.setStreet(landNative.getStreet());
            landResponse.setPrice(landNative.getPrice());
            landResponse.setWard(landNative.getWard());
            landResponse.setCreatedDate(landNative.getCreatedDate());

            return landResponse;
        }
        return null;
    }

    @Override
    public GeneralResponse handleTransaction(TransactionRequest request) {
        Account account = accountRepository.findByNameLoginAndStatus(request.getAddress(), AccountStatus.active.toString());
        byte[] byteArray = Base64.decodeBase64(account.getPrivateKey().getBytes());
        String privateTemp =  new String(byteArray);
        Land land = landRepository.getByLandId(request.getLandId(), LandStatus.active.toString());
        if (account == null || land == null) {
            return new GeneralResponse(false);
        } else {
            try {
                Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
                Credentials credentials = Credentials.create(privateTemp);
                String addressContract = MyFile.RealFromFile(MyFile.ADDRESS_CONTRACT_FILE);
                BigInteger gasLimit = BigInteger.valueOf(672197500);
                BigInteger gasPrice =
                        Convert.toWei("2000000", Convert.Unit.WEI).toBigInteger();
                ManageRealEsate manageRealEsate = ManageRealEsate.load(addressContract, web3j, credentials,
                        gasLimit, gasPrice);
                EthGetBalance balanceResult = MyWeb3j.web3j.ethGetBalance(account.getAddress(),
                        DefaultBlockParameterName.LATEST).send();
//Obtain the BigInteger balance representation, in the wei unit.
                BigInteger balanceInWei = balanceResult.getBalance();
                System.out.println(Convert.toWei(new BigDecimal(land.getPrice()), Convert.Unit.ETHER));
                System.out.println(Convert.toWei(new BigDecimal(balanceInWei), Convert.Unit.ETHER));
                if(balanceInWei.compareTo(new BigInteger(land.getPrice())) == -1){
                    return new GeneralResponse(false, "not-enough-money");
                }
                TransactionReceipt transBuy = manageRealEsate.transferLand(account.getAddress(), BigInteger.valueOf(request.getLandId())).send();
                if (transBuy.isStatusOK()) {
//                    List<ManageRealEsate.TransferEventResponse> transferEventResponses = manageRealEsate.getTransferEvents(transBuy);
                    String eth = CurrencyConverter.VNDToETH(land.getPrice());
                    if (MyWeb3j.transferEth(privateTemp,web3j, land.getAddressHolder(), eth)) {
                        return new GeneralResponse(true);
                    } else {//rollback land to owner
                        transBuy = manageRealEsate.transferLand(land.getAddressHolder(), BigInteger.valueOf(request.getLandId())).send();
                    }
                } else {
                    return new GeneralResponse(false);
                }
            } catch (Exception e) {
                if (e.getMessage().contains("sender doesn't have enough funds to send tx")) {
                    System.out.println("Tài khoản không đủ gas để chạy transaction mua");
                    return new GeneralResponse(false, "not-enough-gas");
                }
                e.printStackTrace();
                return new GeneralResponse(false);
            }
        }
        return new GeneralResponse(false);
    }
}
