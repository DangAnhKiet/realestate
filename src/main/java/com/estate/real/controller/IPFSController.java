package com.estate.real.controller;

import com.estate.real.service.inf.IPFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping(value = "image/upload")
public class IPFSController {

    @Autowired
    IPFSService ipfsService;

    @RequestMapping(value = "/update/image", method = RequestMethod.POST)
    public String updateImage(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng chọn một hình ảnh để cập nhật");
            return "wrong";
        }
        return ipfsService.uploadImageNew(file);
    }
}
