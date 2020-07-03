package com.estate.real.model.response;

import com.estate.real.document.Land;
import com.estate.real.model.enums.StatusLand;
import lombok.Data;

@Data
public class LandResponse {
    private String addressSeller;
    private String district;
    private String street;
    private String price;
    private String image;
    private StatusLand status;


    public LandResponse() {
    }

    public LandResponse(Land land) {
        this.addressSeller = land.getAddressSeller();
        this.district = land.getDistrict();
        this.street = land.getStreet();
        this.price = land.getPrice();
        this.image = land.getImage();
        this.status = land.getStatus();
    }
}
