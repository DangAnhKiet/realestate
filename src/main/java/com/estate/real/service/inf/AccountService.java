package com.estate.real.service.inf;

import com.estate.real.document.Account;
import com.estate.real.document.History;
import com.estate.real.model.request.*;
import com.estate.real.model.response.AccountResponse;
import com.estate.real.model.response.GeneralResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AccountService {

    public GeneralResponse addAccount(AccountRequest request);

    public List<Account> getAllByStatus(String status);

    public List<AccountResponse> getAll();

    public String login(HttpServletRequest httpServletRequest, AccountLoginRequest request);

    public Account getAccountByNameLogin(String nameLogin);

    public GeneralResponse updateImage(ImageRequest request);

    public GeneralResponse register(AccountRegisterRequest registerRequest);

    public GeneralResponse updatePrivateKey(ChangePrivateKeyRequest request);

    public GeneralResponse changePassword(ChangePasswordRequest request);

    public String getETHFromVND(String vnd);

    public List<History> getListHistory(String nameLogin);
}
