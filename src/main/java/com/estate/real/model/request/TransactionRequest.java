package com.estate.real.model.request;

import lombok.Data;

@Data
public class TransactionRequest {
    private String address;
    private int landId;
}
