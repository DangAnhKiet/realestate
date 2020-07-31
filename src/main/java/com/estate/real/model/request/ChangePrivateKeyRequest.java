package com.estate.real.model.request;

import lombok.Data;

@Data
public class ChangePrivateKeyRequest {
    private String nameLogin;
    private String privateKey;
}
