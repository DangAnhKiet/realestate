package com.estate.real.service.impl;

import com.estate.real.Repository.inf.AccountRepository;
import com.estate.real.document.Account;
import com.estate.real.model.enums.AccountStatus;
import com.estate.real.model.enums.Role;
import com.estate.real.model.request.AccountLoginRequest;
import com.estate.real.model.request.AccountRegisterRequest;
import com.estate.real.model.request.AccountRequest;
import com.estate.real.model.request.ImageRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.service.inf.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public GeneralResponse addAccount(AccountRequest request) {
        Account account = new Account();
        account.setPrivateKey(request.getAddress());
        account.setFullName(request.getFullName());
        account.setNameLogin(request.getNameLogin());
        String password = Base64.getEncoder().encodeToString(request.getPassword().getBytes());
        account.setPassword(password);
        account.setRole(request.getRole());
        account.setStatus(AccountStatus.active);
        account.setPhoneNumber(request.getPhoneNumber());
        account.setPrivateKey(request.getPrivateKey());

//        String address = MyWeb3j.getAddress(request.getPrivateKey());
//        if(!address.isEmpty()){
//            account.setAddress(address);
//            accountRepository.save(account);
//            return new GeneralResponse(true);
//        }else{
//            return new GeneralResponse(false);
//        }
        accountRepository.save(account);
        return new GeneralResponse(true);
    }

    @Override
    public List<Account> getAllByStatus(String status) {
        return accountRepository.findAllByStatus(status);
    }

    @Override
    public GeneralResponse login(AccountLoginRequest request) {
        Account account = accountRepository.findByNameLogin(request.getNameLogin());
        if (account == null) {
            return new GeneralResponse(false);
        }
        String passwordRequest = Base64.getEncoder().encodeToString(request.getPassword().getBytes());
        if (!account.getPassword().equals(passwordRequest)) {
            return new GeneralResponse(false);
        } else {
            if (account.getRole().equals(Role.admin)) {
                return new GeneralResponse(true, "admin");
            } else if (account.getRole().equals(Role.member)) {
                return new GeneralResponse(true, "member");
            } else {
                return new GeneralResponse(false);
            }
        }
    }

    @Override
    public Account getAccountByNameLogin(String nameLogin) {
        return accountRepository.findByNameLogin(nameLogin);
    }

    @Override
    public GeneralResponse updateImage(ImageRequest request) {
        Account account = accountRepository.findByNameLogin(request.getNameLogin());
        if (account == null) {
            return new GeneralResponse(false);
        }
        Map<String, Object> map = new HashMap<>();

        map.put("image", request.getImage());
        accountRepository.updateImage(request.getNameLogin(), map);
        return new GeneralResponse(true);
    }

    @Override
    public GeneralResponse register(AccountRegisterRequest registerRequest) {
        Account account = accountRepository.findByNameLogin(registerRequest.getNameLogin());
        if (account != null) {
            return new GeneralResponse(false, "account already exist!!!");
        }
        String password = Base64.getEncoder().encodeToString(registerRequest.getPassword().getBytes());

        Account accountNew = new Account();
        accountNew.setNameLogin(registerRequest.getNameLogin());
        accountNew.setPassword(password);
        accountNew.setEmail(registerRequest.getEmail());
        accountNew.setPhoneNumber(registerRequest.getPhoneNumber());
        accountNew.setRole(Role.member);
        accountRepository.save(accountNew);
        return new GeneralResponse(true, "success");
    }
}
