package com.estate.real.service.inf;

import com.estate.real.model.response.GeneralResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IPFSService {
    public String uploadImage(byte[] arrByte);

    public String pinHashImage(String hashImage);

    public String uploadImageNew(MultipartFile file);

    public GeneralResponse uploadImageInfo(MultipartFile file);

}
