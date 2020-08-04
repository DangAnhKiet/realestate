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
    public List<JSONObject> updateAddressHolder(@RequestBody String landId) throws Exception {
        List<JSONObject> stringList = new ArrayList<>();
        for (HistoryLandResponse landResponse : landService.getHistoryFromNetwork(landId)){
            JSONObject objList = new JSONObject();
            objList.put("timestamp",landResponse.getTimestamp());
            objList.put("buyer",landResponse.getBuyer());
            objList.put("seller",landResponse.getSeller());
            objList.put("price",landResponse.getPrice());
            objList.put("image",landResponse.getImage());

            stringList.add(objList);
        }
        return stringList;
    }

}
