package com.estate.real.utils;

public class FormatPrice {
    public static String StandPriceForTransfer(String price){
        if(!price.isEmpty()){
            return price.replaceAll(".","");
        }
        return "";
    }
}
