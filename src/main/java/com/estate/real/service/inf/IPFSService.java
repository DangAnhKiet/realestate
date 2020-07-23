package com.estate.real.service.inf;

import io.ipfs.multihash.Multihash;
import org.springframework.web.multipart.MultipartFile;

public interface IPFSService {
    public String uploadImage(byte[] arrByte);

    public String pinHashImage(String hashImage);

    public String uploadImageNew(MultipartFile file);
}
