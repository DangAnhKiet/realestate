package com.estate.real.service.impl;

import com.estate.real.Repository.inf.AccountRepository;
import com.estate.real.document.Account;
import com.estate.real.model.AccountStatus;
import com.estate.real.model.request.AccountRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.service.inf.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public GeneralResponse addAccount(AccountRequest request) {
        Account account = new Account();
        account.setAddress(request.getAddress());
        account.setFullName(request.getFullName());
        account.setNameLogin(request.getNameLogin());
        account.setPassword(request.getPassword());
        account.setRole(request.getRole());
        account.setStatus(AccountStatus.active);

        accountRepository.save(account);
        return new GeneralResponse(true);
    }

    @Override
    public List<Account> getAllByStatus(String status) {
        return accountRepository.findByStatus(status);
    }
}
