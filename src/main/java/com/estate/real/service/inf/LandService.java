package com.estate.real.service.inf;

import com.estate.real.document.History;
import com.estate.real.document.Land;
import com.estate.real.model.request.*;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.model.response.HistoryLandResponse;
import com.estate.real.model.response.LandResponse;

import java.util.List;

public interface LandService {
    public GeneralResponse addLand(LandRequest request);

    public List<LandResponse> getLandPaging(LandPagingRequest request);

    public List<LandResponse> getAllLand();

    public List<LandResponse> getFilterLand(LandFilterRequest request);

    public List<Land> getAllLandByAddressHolder(String addressHolder);

    public LandResponse getLandById(int idLand);

    public GeneralResponse handleTransaction(TransactionRequest request);

    public GeneralResponse saveTransaction(History history);

    String getBalance(String userLogin);

    public GeneralResponse updateAddressHolder(UpdateAddressRequest request);

    public List<HistoryLandResponse> getHistoryFromNetwork(HistoryLandRequest request) throws Exception;
}
