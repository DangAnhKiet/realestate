package com.estate.real.model.request;

import lombok.Data;

@Data
public class AccountRequest {
    private String nameLogin;
    private String password;
    private String fullName;
    private String role;
    private String status;
    private String address;
}
