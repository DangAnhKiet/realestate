package com.estate.real.controller;

import com.estate.real.Repository.inf.AccountRepository;
import com.estate.real.document.Account;
import com.estate.real.model.request.AccountRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.service.inf.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class RestAccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/account/add", method = RequestMethod.POST)
    public GeneralResponse add(@RequestBody AccountRequest request){
        return accountService.addAccount(request);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Account> add(@RequestParam String status){
        return accountService.getAllByStatus(status);
    }
}
