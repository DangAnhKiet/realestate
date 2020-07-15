package com.estate.real.model.request;

import lombok.Data;

@Data
public class LandFilterRequest {
    private String district;
    private String street;
    private String price;

    public LandFilterRequest() {
    }
}
