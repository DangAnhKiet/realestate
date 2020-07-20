package com.estate.real.service.impl;

import com.estate.real.Repository.inf.AccountRepository;
import com.estate.real.document.Account;
import com.estate.real.model.enums.AccountStatus;
import com.estate.real.model.enums.Role;
import com.estate.real.model.request.AccountLoginRequest;
import com.estate.real.model.request.AccountRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.service.inf.AccountService;
import com.estate.real.utils.MyWeb3j;
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
        account.setPrivateKey(request.getAddress());
        account.setFullName(request.getFullName());
        account.setNameLogin(request.getNameLogin());
//        String password = Base64.getEncoder().encodeToString();
        account.setPassword(request.getPassword());
        account.setRole(request.getRole());
        account.setStatus(AccountStatus.active);
        account.setPhoneNumber(request.getPhoneNumber());
        account.setPrivateKey(request.getPrivateKey());

        String address = MyWeb3j.getAddress(request.getPrivateKey());
        if(!address.isEmpty()){
            account.setAddress(address);
            accountRepository.save(account);
            return new GeneralResponse(true);
        }else{
            return new GeneralResponse(false);
        }
    }

    @Override
    public List<Account> getAllByStatus(String status) {
        return accountRepository.findAllByStatus(status);
    }

    @Override
    public GeneralResponse login(AccountLoginRequest request) {
        Account account = accountRepository.findByNameLogin(request.getNameLogin(), AccountStatus.active.toString());
        if (account == null){
            return new GeneralResponse(false);
        }

        if (!request.getPassword().equals(account.getPassword())){
            return new GeneralResponse(false);
        }else{
            if(Role.admin.toString().equals(account.getRole())){
                return new GeneralResponse(true,"admin");
            }else if(Role.member.toString().equals(account.getRole())){
                return new GeneralResponse(true,"member");
            }else{
                return new GeneralResponse(false);

            }
        }
    }

    @Override
    public Account getAccountByNameLogin(String nameLogin) {
        return accountRepository.findByNameLogin(nameLogin);
    }
}
