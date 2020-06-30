package com.estate.real.model.response;

import lombok.Data;

@Data
public class GeneralResponse {
    private boolean success;
    private String strResult;

    public GeneralResponse() {
    }

    public GeneralResponse(boolean success) {
        this.success = success;
    }

    public GeneralResponse(String strResult){
        this.strResult = strResult;
    }
}
