package com.estate.real.model.request;

import lombok.Data;

@Data
public class UpdateAddressRequest {
    private String address;
    private int landId;
}

