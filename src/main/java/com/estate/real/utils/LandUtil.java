package com.estate.real.utils;

import com.estate.real.document.Land;
import com.estate.real.model.request.LandRequest;

public class LandUtil {
    public static LandRequest formatRequest(LandRequest land){
       if(land != null){
           LandRequest standLand = new LandRequest();
            standLand.setPrice(FormatPrice.StandPriceForTransfer(land.getPrice()));
            standLand.setAddressSeller(land.getAddressSeller());
            standLand.setDistrict(land.getDistrict());
            standLand.setPathImage(land.getPathImage());
            standLand.setStreet(land.getStreet());
            standLand.setWard(land.getWard());
            standLand.setDescription(land.getDescription());
            return standLand;
       }
       return null;
    }

    public static void main(String[] args) {
        String a = "2.000.000.000";
        System.out.println(a.replaceAll(".",""));
    }
}
