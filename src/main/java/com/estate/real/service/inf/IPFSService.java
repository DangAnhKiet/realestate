package com.estate.real.service.inf;

public interface IPFSService {
    public String uploadImage(byte[] arrByte);

    public boolean pinHashImage(String hashImage);
}
