package com.estate.real.service.inf;

import com.estate.real.document.Land;
import com.estate.real.model.request.LandPagingRequest;
import com.estate.real.model.request.LandRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.model.response.LandResponse;

import java.util.List;

public interface LandService {
    public GeneralResponse addLand(LandRequest request);

    public List<LandResponse> getLandPaging(LandPagingRequest request);

    public List<LandResponse> getAllLand();
}
