package com.estate.real.Repository.extend;

import com.estate.real.model.response.GeneralResponse;

import java.util.Map;

public interface AccountRepositoryExtend {

    public boolean updateDetail(String name, Map<String, Object> updateValues);
}
