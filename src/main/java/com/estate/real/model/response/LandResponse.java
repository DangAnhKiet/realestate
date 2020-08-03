package com.estate.real.model.response;

import com.estate.real.document.Land;
import lombok.Data;

@Data
public class LandResponse {
    private String addressSeller;
    private String ownerName;
    private String district;
    private String street;
    private String price;
    private String image;
    private String status;
    private int landId;
    private String ward;
    private String description;
    private String createdDate;
//    private String updatedDate;
//    private String createdBy;
//    private String updatedBy;

    public LandResponse() {
    }

    public LandResponse(Land land) {
        this.addressSeller = land.getAddressHolder();
        this.ownerName = land.getNameOwner();
        this.district = land.getDistrict();
        this.street = land.getStreet();
        this.price = land.getPrice();
        this.image = land.getPathImage();
        this.status = land.getStatus();
        this.landId = land.getLandId();
        this.description = land.getDescription();
        this.ward = land.getWard();
        this.createdDate = land.getCreatedDate();
    }
}
