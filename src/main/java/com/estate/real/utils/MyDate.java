package com.estate.real.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    public static String getNow(){
        String result = "";
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        return formatter.format(date);
    }

    public static void main(String[] args) {
//        System.out.println(getNow());
    }
}
