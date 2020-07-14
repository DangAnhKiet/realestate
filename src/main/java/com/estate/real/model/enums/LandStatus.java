package com.estate.real.model.enums;

public enum LandStatus {
    active(1),
    pending(2),
    deleted(3);

    private int value;

    private LandStatus(int value){
        this.value = value;
    }

}
