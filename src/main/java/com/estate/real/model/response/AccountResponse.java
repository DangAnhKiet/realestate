package com.estate.real.model.response;

import com.estate.real.document.Account;
import com.estate.real.model.enums.AccountStatus;
import com.estate.real.model.enums.Role;
import lombok.Data;

@Data
public class AccountResponse {
    private String nameLogin;
    private String fullName;
//    private String password;
    private Role role;
    private String email;
    private String gender;
    private AccountStatus status;
//    private String privateKey;
    private String phoneNumber;
    private String img;


    public AccountResponse() {
    }

    public AccountResponse(Account account) {
        this.email = account.getEmail();
        this.fullName = account.getFullName();
        this.gender = account.getGender();
        this.nameLogin = account.getNameLogin();
//        this.password = account.getPassword();
        this.role = account.getRole();
        this.status = account.getStatus();
//        this.privateKey = account.getPrivateKey();
        this.phoneNumber = account.getPhoneNumber();
        this.img = account.getImg();
    }
}