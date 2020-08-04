package com.estate.real.controller;

import com.estate.real.document.Land;
import com.estate.real.model.request.*;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.model.response.HistoryLandResponse;
import com.estate.real.model.response.LandResponse;
import com.estate.real.service.inf.LandService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public GeneralResponse handleTransaction(@RequestBody TransactionRequest request) {
        return landService.handleTransaction(request);
    }

    @RequestMapping(value = "/checkBalance", method = RequestMethod.POST)
    public GeneralResponse getBalance(@RequestBody String userLogin) {
        String balance = landService.getBalance(userLogin);
        if (balance.contains("null")) {
            return new GeneralResponse(false, "error-get-balance");
        }
        return new GeneralResponse(true, balance);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public GeneralResponse updateAddressHolder(@RequestBody UpdateAddressRequest request) {
        return landService.updateAddressHolder(request);
    }

    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public String updateAddressHolder(@RequestBody String landId) throws Exception {
        JSONArray stringList = new JSONArray();
        List<HistoryLandResponse>  historyLandResponses = landService.getHistoryFromNetwork(landId);
        for (HistoryLandResponse landResponse :historyLandResponses ){
            JSONObject obj = new JSONObject();
            obj.put("timestamp",landResponse.getTimestamp());
            obj.put("buyer",landResponse.getBuyer());
            obj.put("seller",landResponse.getSeller());
            obj.put("price",landResponse.getPrice());
            obj.put("image",landResponse.getImage());

            stringList.put(obj);
        }
        return stringList.toString();
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public GeneralResponse updateLandStatus(@RequestParam int landId) {
        return landService.updateLandStatus(landId);
    }
}
