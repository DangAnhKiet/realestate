package com.estate.real.model.response;

import lombok.Data;

@Data
public class GeneralResponse {
    private boolean success;

    public GeneralResponse() {
    }

    public GeneralResponse(boolean success) {
        this.success = success;
    }
}
