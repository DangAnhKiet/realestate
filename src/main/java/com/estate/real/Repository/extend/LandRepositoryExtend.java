package com.estate.real.Repository.extend;

import com.estate.real.document.Land;
import com.estate.real.model.request.LandPagingRequest;
import com.estate.real.model.response.LandResponse;

import java.util.List;

public interface LandRepositoryExtend {
    public List<Land> getLandPaging(LandPagingRequest request);
}
