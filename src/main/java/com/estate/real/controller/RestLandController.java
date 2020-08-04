package com.estate.real.controller;

import com.estate.real.config.ContractInfo;
import com.estate.real.document.Account;
import com.estate.real.document.Land;
import com.estate.real.model.request.LandFilterRequest;
import com.estate.real.model.request.LandPagingRequest;
import com.estate.real.model.request.LandRequest;
import com.estate.real.model.request.TransactionRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.model.response.LandResponse;
import com.estate.real.service.inf.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.util.List;

@RestController
@RequestMapping(value = "api/land")
public class RestLandController {
    @Autowired
    LandService landService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public GeneralResponse add(@RequestBody LandRequest request) {
        return landService.addLand(request);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public List<LandResponse> getLandPaging(@RequestBody LandPagingRequest request) {
        return landService.getLandPaging(request);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public List<LandResponse> getFilterLand(@RequestBody LandFilterRequest request) {
        return landService.getFilterLand(request);
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public List<Land> getAllLandByAddressHolder(@RequestParam String address) {
        return landService.getAllLandByAddressHolder(address);
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public GeneralResponse getAllLandByAddressHolder(@RequestBody TransactionRequest request) {
        return landService.handleTransaction(request);
    }

    @RequestMapping(value = "/checkBalance", method = RequestMethod.POST)
    public GeneralResponse getBalance(@RequestBody String userLogin) {
       String balance = landService.getBalance(userLogin);
       if(balance.contains("null")){
           return new GeneralResponse(false,"error-get-balance");
       }
       return new GeneralResponse(true,balance);
    }
}
