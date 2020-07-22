package com.estate.real.controller;

import com.estate.real.document.Account;
import com.estate.real.model.request.AccountLoginRequest;
import com.estate.real.model.request.AccountRequest;
import com.estate.real.model.request.ImageRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.service.inf.AccountService;
import com.estate.real.utils.MyIPFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "account")
public class RestAccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public GeneralResponse addAccount(@RequestBody AccountRequest request) {
        return accountService.addAccount(request);
    }

    @RequestMapping(value = "/get/status", method = RequestMethod.GET)
    public List<Account> getAllByStatus(@RequestParam String status) {
        return accountService.getAllByStatus(status);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public GeneralResponse login(@RequestBody AccountLoginRequest request) {
        return accountService.login(request);
    }

    @RequestMapping(value = "/get/name", method = RequestMethod.POST)
    public Account getAccountByNameLogin(@RequestParam String name) {
        return accountService.getAccountByNameLogin(name);
    }

    @RequestMapping(value = "/update/image", method = RequestMethod.POST)
    public String updateImage(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng chọn một hình ảnh để cập nhật");
            return "wrong";
        }
        try{
            byte[] bytes = file.getBytes();
            String hashImage = MyIPFS.uploadImage(bytes);
            boolean statusPin = MyIPFS.pinHashImage(hashImage);
            System.out.println("hash image: "+ hashImage);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
//        return accountService.updateImage(request);
    }
}
