package com.estate.real.controller;

import com.estate.real.document.Account;
import com.estate.real.model.enums.StatusLogin;
import com.estate.real.model.request.AccountLoginRequest;
import com.estate.real.model.request.AccountRequest;
import com.estate.real.model.response.AccountResponse;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.service.inf.AccountService;
import com.estate.real.service.inf.IPFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "api/account")
public class RestAccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    IPFSService ipfsService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public GeneralResponse addAccount(@RequestBody AccountRequest request) {
        return accountService.addAccount(request);
    }

    @RequestMapping(value = "/get/status", method = RequestMethod.GET)
    public List<Account> getAllByStatus(@RequestParam String status) {
        return accountService.getAllByStatus(status);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody AccountLoginRequest request, HttpServletRequest servletRequest) {
        String strResponse = accountService.login(servletRequest,request);
        if(strResponse.contains(StatusLogin.ERROR_PASSWORD.toString())){
//            model.addAttribute("errorLogin","Sai mật khẩu");
            return "Sai mật khẩu";
        }else if(strResponse.contains(StatusLogin.EXIST_ACCOUNT.toString())){
//            model.addAttribute("errorLogin","Tài khoản không tồn tại");
            return "Tài khoản không tồn tại";
        }else{
//            model.addAttribute("errorLogin","Tài khoản đã bị khóa");
            return strResponse;
        }
    }

    @RequestMapping(value = "/get/name", method = RequestMethod.POST)
    public String getAccountByNameLogin(@RequestParam String name) {
        Account account = accountService.getAccountByNameLogin(name);
        if(account != null){
            System.out.println("Get account by usename login: "+account.toString());
            return account.getAddress();
        }else{
            System.out.println("Username khong ton tai.");
            return "";
        }
    }

    @RequestMapping(value = "/update/image", method = RequestMethod.POST)
    public GeneralResponse updateImage(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng chọn một hình ảnh để cập nhật");
            return new GeneralResponse(false);
        }
        return ipfsService.uploadImageInfo(file);
    }
}
