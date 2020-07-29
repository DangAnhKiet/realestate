package com.estate.real.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CurrencyConverter {
    private static final String USER_AGENT = "Mozilla/5.0";
    public static final String API_USD_TO_VND = "http://api.currencylayer.com/live?access_key=792f47f2678825a843b44239e05c68b8&format=1";
    public static final String API_EHT_TO_USD = "https://api.etherscan.io/api?module=stats&action=ethprice&apikey";

    private static String GetStringFromUrl(String urlAPI) {
        String result = "";
        try {
            URL objUrl = new URL(urlAPI);
            HttpURLConnection connection = (HttpURLConnection) objUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent",USER_AGENT);
            int responseCode = connection.getResponseCode();
//            System.out.println("Response code from url api: "+responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                result = response.toString();
            } else {
                System.out.println("GET request not worked");
            }

        } catch (Exception e) {
            if (e instanceof MalformedURLException) {
                System.out.println("Loi get api");
                e.printStackTrace();
                result = "";
            }
            if (e instanceof IOException) {
                System.out.println("Loi connect url api");
                e.printStackTrace();
                result = "";
            }if(e instanceof JSONException){
                System.out.println("Loi chuyen doi string to json");
                e.printStackTrace();
            }
        }
        return result;
    }
    public static String VNDToETH(String currVND){
        String result = "0";
        String strUSD = CurrencyConverter.GetStringFromUrl(CurrencyConverter.API_EHT_TO_USD);
        String strVND = CurrencyConverter.GetStringFromUrl(CurrencyConverter.API_USD_TO_VND);
        try{
            String currUsd = new JSONObject(strUSD).getJSONObject("result").getString("ethusd");
            String currVnd = new JSONObject(strVND).getJSONObject("quotes").get("USDVND").toString();

            int usd = Integer.parseInt(currUsd.substring(0, currUsd.indexOf(".")));
            int vnd = Integer.parseInt(currVnd);
            BigDecimal payVnd = BigDecimal.valueOf(Long.parseLong(currVND));
            if(usd != 0 && vnd != 0 && !payVnd.equals(0)){
                BigDecimal temp =  payVnd.divide(BigDecimal.valueOf(usd*vnd),3, RoundingMode.HALF_DOWN);
                result = temp.toString();
            }else{
                System.out.println("Lỗi mệnh giá đổi ra có gia trị zero");
            }
            System.out.println("eth to usd "+ usd);
            System.out.println("usd to vnd "+vnd);
        }catch (Exception e){
            if(e instanceof JSONException){
                System.out.println("Loi get json object");
                e.printStackTrace();
            }else{
                e.printStackTrace();
            }
        }
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        VNDToETH("1000000000");
    }

}
