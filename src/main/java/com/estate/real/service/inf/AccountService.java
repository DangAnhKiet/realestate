package com.estate.real.service.inf;

import com.estate.real.document.Account;
import com.estate.real.model.request.AccountLoginRequest;
import com.estate.real.model.request.AccountRequest;
import com.estate.real.model.response.GeneralResponse;

import java.util.List;

public interface AccountService {

    public GeneralResponse addAccount(AccountRequest request);

    public List<Account> getAllByStatus(String status);

    public GeneralResponse login(AccountLoginRequest request);

}
