package com.estate.real.controller;

import com.estate.real.service.inf.IPFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@CrossOrigin
@RestController
@RequestMapping(value = "api/ipfs")
public class IPFSController {

    @Autowired
    IPFSService ipfsService;

    @RequestMapping(value = "/img/update", method = RequestMethod.POST)
    public String updateImage(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        return ipfsService.uploadImageNew(file);
//        return null;
    }
}
