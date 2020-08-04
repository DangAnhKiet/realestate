package com.estate.real.service.impl;

import com.estate.real.Repository.inf.AccountRepository;
import com.estate.real.Repository.inf.HistoryRepository;
import com.estate.real.Repository.inf.LandRepository;
import com.estate.real.config.ContractInfo;
import com.estate.real.contract.ManageRealEsate;
import com.estate.real.document.Account;
import com.estate.real.document.History;
import com.estate.real.document.Land;
import com.estate.real.model.enums.AccountStatus;
import com.estate.real.model.enums.LandStatus;
import com.estate.real.model.request.LandFilterRequest;
import com.estate.real.model.request.LandPagingRequest;
import com.estate.real.model.request.LandRequest;
import com.estate.real.model.request.TransactionRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.model.response.LandResponse;
import com.estate.real.service.inf.LandService;
import com.estate.real.utils.CurrencyConverter;
import com.estate.real.utils.MyDate;
import com.estate.real.utils.MyFile;
import com.estate.real.utils.MyWeb3j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.abi.EventEncoder;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple8;
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

    @Autowired
    HistoryRepository historyRepository;

    @Override
    public GeneralResponse addLand(LandRequest request) {
        Account account = accountRepository.findByAddress(request.getAddressSeller());
        if (account == null) {
            return new GeneralResponse(false, "locked-account");
        }
        Land land = new Land();
        land.setAddressHolder(request.getAddressSeller());
        land.setNameOwner(account.getFullName().toUpperCase());
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
        Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
//            Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
        Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
        String addressContract = MyFile.RealFromFile(MyFile.ADDRESS_CONTRACT_FILE);
        BigInteger gasLimit = BigInteger.valueOf(672197500);
        BigInteger gasPrice =
                Convert.toWei("2000000", Convert.Unit.WEI).toBigInteger();
        ManageRealEsate manageRealEsate = ManageRealEsate.load(addressContract, web3j, credentials,
                gasLimit, gasPrice);
        try {
            if (manageRealEsate != null) {
                TransactionReceipt transactionReceipt = manageRealEsate.addLand(land.getAddressHolder(), land.getDistrict(), land.getStreet(),
                        land.getPathImage(), land.getPrice(), land.getWard(), land.getDescription()).send();
                System.out.println("Trạng thái của quá trình thêm land vào blockchain: " + transactionReceipt.isStatusOK());
                if (transactionReceipt.isStatusOK()) {
                    //Get event để thêm landId vào db
                    manageRealEsate
                            .addEventObservable(DefaultBlockParameterName.LATEST, DefaultBlockParameterName.LATEST)
                            .subscribe(event -> {
                                final int landId = Integer.valueOf(event._landID.toString());
                                final String addressOwner = event._owner.toString();
                                System.out.println(" landid vua moi add vao blockchain: " + landId);
                                System.out.println(" address chu dat moi add: " + addressOwner);
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
            landResponse.setOwnerName(landResponse.getOwnerName());
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
        Account accountBuyer = accountRepository.findByNameLoginAndStatus(request.getAddress(), AccountStatus.active.toString());
        byte[] byteArray = Base64.decodeBase64(accountBuyer.getPrivateKey().getBytes());
        String privateKeyBuyer = new String(byteArray);
        Land landTransfer = landRepository.getByLandId(request.getLandId(), LandStatus.active.toString());
        if (accountBuyer == null || landTransfer == null) {
            return new GeneralResponse(false);
        } else {
            try {
                Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
                Credentials credentials = Credentials.create(ContractInfo.pkDeploy);
                String addressContract = MyFile.RealFromFile(MyFile.ADDRESS_CONTRACT_FILE);
                BigInteger gasLimit = BigInteger.valueOf(672197500);
                BigInteger gasPrice =
                        Convert.toWei("2000000", Convert.Unit.WEI).toBigInteger();
                ManageRealEsate manageRealEsate = ManageRealEsate.load(addressContract, web3j, credentials,
                        gasLimit, gasPrice);
                //Kiểm tra só tiền trong ví của người mua với giá đất hiện tại
                EthGetBalance balanceResult = web3j.ethGetBalance(accountBuyer.getAddress(),
                        DefaultBlockParameterName.LATEST).send();
                BigInteger balanceInWei = balanceResult.getBalance();
                if (balanceInWei.compareTo(new BigInteger(landTransfer.getPrice())) == -1) {
                    return new GeneralResponse(false, "not-enough-money");
                }
                //Thực hiện transfer
//                event Transfer(address indexed _from, address indexed _to, uint _landId);
//            function transferLand(address _landBuyer,address _ownerLand, uint _landID)
                TransactionReceipt receiptTransfer = manageRealEsate.transferLand(accountBuyer.getAddress(), landTransfer.getAddressHolder(),
                        BigInteger.valueOf(landTransfer.getLandId()),MyDate.getNow(),landTransfer.getPathImage()).send();
                if (receiptTransfer.isStatusOK()) {
                    manageRealEsate
                            .transferEventObservable(DefaultBlockParameterName.LATEST, DefaultBlockParameterName.LATEST)
                            .subscribe(event -> {
                                final String transferFrom = event._from;
                                final String transferTo = event._to;
                                final int landId = Integer.valueOf(event._landId.toString());
                                System.out.println(" dia chi nguoi ban: " + transferFrom);
                                System.out.println(" dia chi nguoi mua: " + transferTo);
                                System.out.println(" id cua dat: " + landId);
                            });
                    //Chuyển tiền:
                    String eth = CurrencyConverter.VNDToETH(landTransfer.getPrice());
                    byte[] byteArrayNew = Base64.decodeBase64(accountBuyer.getPrivateKey().getBytes());
                    String privateKeyBuyerNew = new String(byteArrayNew);
                    if (MyWeb3j.transferEth(privateKeyBuyerNew, web3j, landTransfer.getAddressHolder(), eth)) {
                        System.out.println("Giao dich mua dat thanh cong");
                        //
                        return new GeneralResponse(true);
                    } else {//rollback land to previous owner
                        System.out.println("Chuyen tien that bai.");
                        TransactionReceipt receiptTransferNew = manageRealEsate.transferLand(landTransfer.getAddressHolder(),
                                accountBuyer.getAddress(),
                                BigInteger.valueOf(landTransfer.getLandId()), MyDate.getNow(), landTransfer.getPathImage()).send();
                        if (receiptTransferNew.isStatusOK()) {
                            System.out.println("Chuyển đất ngược lại chủ cũ thành công.");
                            manageRealEsate
                                    .transferEventObservable(DefaultBlockParameterName.LATEST, DefaultBlockParameterName.LATEST)
                                    .subscribe(event -> {
                                        final String transferFrom = event._from;
                                        final String transferTo = event._to;
                                        final int landId = Integer.valueOf(event._landId.toString());
                                        System.out.println(" dia chi nguoi ban: " + transferFrom);
                                        System.out.println(" dia chi nguoi mua: " + transferTo);
                                        System.out.println(" id cua dat: " + landId);
                                    });
                        }
                        return new GeneralResponse(false, "error-transfer-eth");
                    }
                }
                return new GeneralResponse(false);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                if (null != e.getMessage() && e.getMessage().contains("sender doesn't have enough funds to send tx")) {
                    System.out.println("Tài khoản không đủ gas để chạy transaction mua");
                    return new GeneralResponse(false, "not-enough-gas");
                }
                e.printStackTrace();
                return new GeneralResponse(false);
            }
        }
    }

    @Override
    public GeneralResponse saveTransaction(History history) {
        historyRepository.save(history);
        return new GeneralResponse(true);
    }

    @Override
    public String getBalance(String userLogin) {
        Account account = accountRepository.findByNameLoginAndStatus(userLogin, AccountStatus.active.toString());
        if (account == null) {
            return "";
        }
        byte[] byteArray = Base64.decodeBase64(account.getPrivateKey().getBytes());
        String privateTemp = new String(byteArray);
        Web3j web3j = Web3j.build(new HttpService(ContractInfo.locationEthereum));
        Credentials credentials = Credentials.create(privateTemp);
        String addressContract = MyFile.RealFromFile(MyFile.ADDRESS_CONTRACT_FILE);
        BigInteger gasLimit = BigInteger.valueOf(672197500);
        BigInteger gasPrice =
                Convert.toWei("2000000", Convert.Unit.WEI).toBigInteger();
        ManageRealEsate manageRealEsate = ManageRealEsate.load(addressContract, web3j, credentials,
                gasLimit, gasPrice);
        EthGetBalance balanceResult;
        try {
            balanceResult = web3j.ethGetBalance(account.getAddress(), DefaultBlockParameterName.LATEST).send();
        } catch (Exception e) {
            System.out.println("Loi số dư ví tiền của người mua đất");
            e.printStackTrace();
            return "null";
        }
        BigInteger balanceInWei = balanceResult.getBalance();
        System.out.println(Convert.toWei(new BigDecimal(balanceInWei), Convert.Unit.WEI));
        System.out.println(balanceInWei.toString());
        if (balanceInWei.toString().length() >= 18) {
            return balanceInWei.toString().substring(0, balanceInWei.toString().length() - 18);
        } else {
            return "0";
        }
    }
}
