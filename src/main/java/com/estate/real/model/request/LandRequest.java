package com.estate.real.model.request;

import lombok.Data;

import java.util.List;

@Data
public class LandRequest {
    private String addressSeller;
    private String district;
    private String street;
    private String price;
    private String image;
}
