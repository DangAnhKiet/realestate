package com.estate.real.model.request;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String oldPass;
    private String newPass;
}
