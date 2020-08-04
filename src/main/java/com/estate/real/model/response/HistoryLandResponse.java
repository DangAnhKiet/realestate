package com.estate.real.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HistoryLandResponse {
    private String timestamp;
    private String seller;
    private String buyer;
    private String price;
    private String image;
}
