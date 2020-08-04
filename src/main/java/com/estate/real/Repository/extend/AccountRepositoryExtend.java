package com.estate.real.Repository.extend;

import com.estate.real.document.Account;

import java.util.List;
import java.util.Map;

public interface AccountRepositoryExtend {

    public void updateInformation(String nameLogin, Map<String, Object> updateValues);
    public List<Account> getAllLands();
}
