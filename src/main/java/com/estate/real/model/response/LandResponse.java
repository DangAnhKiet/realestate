package com.estate.real.model.response;

import com.estate.real.document.Land;
import lombok.Data;

@Data
public class LandResponse {
    private String addressSeller;
    private String district;
    private String street;
    private String price;
    private String image;
    private int status;
    private int landId;
    private String ward;
    private String description;

    public LandResponse() {
    }

    public LandResponse(Land land) {
        this.addressSeller = land.getAddressHolder();
        this.district = land.getDistrict();
        this.street = land.getStreet();
        this.price = land.getPrice();
        this.image = land.getPathImage();
        this.status = land.getStatus();
        this.landId = land.getLandId();
        this.description = land.getDescription();
        this.ward = land.getWard();
    }
}
