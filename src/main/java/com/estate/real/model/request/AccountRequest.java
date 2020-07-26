package com.estate.real.model.request;

import com.estate.real.model.enums.Role;
import lombok.Data;

@Data
public class AccountRequest {
    private String nameLogin;
    private String password;
    private String fullName;
    private Role role;
    private String status;
    private String address;
    private String phoneNumber;
    private String privateKey;
    private String email;
    private String gender;
    private String img;
}
