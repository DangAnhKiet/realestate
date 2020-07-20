package com.estate.real.model.request;

import com.estate.real.model.enums.AccountStatus;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class AccountRequest {
    private String nameLogin;
    private String password;
    private String fullName;
    private String role;
    private String status;
    private String address;
    private String phoneNumber;
    private String privateKey;
    private String email;
    private String gender;
}
