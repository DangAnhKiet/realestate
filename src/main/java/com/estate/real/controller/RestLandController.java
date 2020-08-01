package com.estate.real.controller;

import com.estate.real.document.Land;
import com.estate.real.model.request.LandFilterRequest;
import com.estate.real.model.request.LandPagingRequest;
import com.estate.real.model.request.LandRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.model.response.LandResponse;
import com.estate.real.service.inf.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<LandResponse> add(@RequestBody LandPagingRequest request) {
        return landService.getLandPaging(request);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public List<LandResponse> add(@RequestBody LandFilterRequest request) {
        return landService.getFilterLand(request);
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public List<Land> add(@RequestParam String address) {
        return landService.getAllLandByAddressHolder(address);
    }
}
