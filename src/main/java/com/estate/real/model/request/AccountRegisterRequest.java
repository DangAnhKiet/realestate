package com.estate.real.model.request;

import lombok.Data;

@Data
public class AccountRegisterRequest {
    //    @NotEmpty(message = "'name login' must not be empty")
    //    @NotNull(message = "'name login' must not be null")
    private String nameLogin;
    private String password;
    private String email;
    private String phoneNumber;
}
