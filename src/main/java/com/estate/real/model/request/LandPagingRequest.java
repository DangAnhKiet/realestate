package com.estate.real.model.request;

import com.estate.real.model.enums.LandStatus;
import lombok.Data;

@Data
public class LandPagingRequest{
    private String id;
    private int limit;
    private String action;
    private LandStatus status;
}
