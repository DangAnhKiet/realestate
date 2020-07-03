package com.estate.real.service.inf;

import com.estate.real.model.request.LandRequest;
import com.estate.real.model.response.GeneralResponse;

public interface LandService {
    public GeneralResponse addLand(LandRequest request);
}
