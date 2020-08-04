package com.estate.real.Repository.extend;

import com.estate.real.document.Land;
import com.estate.real.model.request.LandFilterRequest;
import com.estate.real.model.request.LandPagingRequest;

import java.util.List;
import java.util.Map;

public interface LandRepositoryExtend {

    public List<Land> getLandPaging(LandPagingRequest request);

    public List<Land> getAllLands();

    public List<Land> getFilterLand(LandFilterRequest request);

    public void updateLand(int landId, Map<String, Object> updateValues);

}
