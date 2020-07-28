package com.estate.real.service.impl;

import com.estate.real.Repository.inf.AccountRepository;
import com.estate.real.contanst.AttributeAccount;
import com.estate.real.contanst.Session;
import com.estate.real.document.Account;
import com.estate.real.model.enums.AccountStatus;
import com.estate.real.model.enums.Role;
import com.estate.real.model.enums.StatusLogin;
import com.estate.real.model.request.AccountLoginRequest;
import com.estate.real.model.request.AccountRegisterRequest;
import com.estate.real.model.request.AccountRequest;
import com.estate.real.model.request.ImageRequest;
import com.estate.real.model.response.AccountResponse;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.service.inf.AccountService;
import com.estate.real.utils.MyDate;
import com.estate.real.utils.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    IPFSServiceImpl ipfsService;

    @Override
    public GeneralResponse addAccount(AccountRequest request) {
        Account accountTemp = accountRepository.findByNameLogin(request.getNameLogin(), AccountStatus.active.toString());
        if (accountTemp != null) {
            return new GeneralResponse(false, "error-exist");
        }
        Account account = new Account();
        account.setPrivateKey(request.getAddress());
        account.setFullName(request.getFullName());
        account.setNameLogin(request.getNameLogin());
        String password = Base64.getEncoder().encodeToString(request.getPassword().getBytes());
        account.setPassword(password);
        account.setRole(request.getRole());
        account.setStatus(AccountStatus.active);
        account.setPhoneNumber(request.getPhoneNumber());
        account.setPrivateKey(request.getPrivateKey());
        account.setCreatedBy(request.getCreatedBy());
        account.setUpdatedBy(request.getUpdatedBy());
        account.setCreatedDate(MyDate.getNow());
        account.setUpdatedDate(MyDate.getNow());
        account.setImg(MyFile.RealFromFile(MyFile.PATH_AVATAR_DEFAULT));

//        String address = MyWeb3j.getAddress(request.getPrivateKey());
//        if(!address.isEmpty()){
//            account.setAddress(address);
//            accountRepository.save(account);
//            return new GeneralResponse(true);
//        }else{
//            return new GeneralResponse(false);
//        }
        accountRepository.save(account);
        return new GeneralResponse(true);
    }

    @Override
    public List<Account> getAllByStatus(String status) {
        return accountRepository.findAllByStatus(status);
    }

    @Override
    public String login(HttpServletRequest httpServletRequest,AccountLoginRequest request) {
        if (httpServletRequest.getSession() != null) {
            httpServletRequest.getSession().invalidate();
        } 

        Account account = accountRepository.findByNameLogin(request.getNameLogin(), AccountStatus.active.toString());
        if (account == null) {
            return StatusLogin.EXIST_ACCOUNT.toString();
        }
        String passwordRequest = Base64.getEncoder().encodeToString(request.getPassword().getBytes());
        if (!account.getPassword().equals(passwordRequest)) {
            return StatusLogin.ERROR_PASSWORD.toString();
        }
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setEmail(account.getEmail());
        accountResponse.setFullName(account.getFullName());
        accountResponse.setGender(account.getGender());
        accountResponse.setImg(account.getImg());
        accountResponse.setNameLogin(account.getNameLogin());
        accountResponse.setPhoneNumber(account.getPhoneNumber());
        accountResponse.setRole(account.getRole());
        accountResponse.setStatus(account.getStatus());

        HashSet<String>  hsetSession = (HashSet<String>) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if(hsetSession == null){
           hsetSession = new HashSet<>();
        }
            hsetSession.add(Session.ACCOUNT_LOGIN+"-"+accountResponse.getNameLogin()+"-"+accountResponse.getRole()+"-"+accountResponse.getImg());
            httpServletRequest.getSession().setAttribute("MY_SESSION",hsetSession);
            if(null != accountResponse.getRole() && Role.admin.toString().contains(accountResponse.getRole().toString())){
                return "admin";
            }
            if(null != accountResponse.getRole() && Role.member.toString().contains(accountResponse.getRole().toString())){
                return "member";
            }
        return StatusLogin.LOCK_ACCOUNT.toString();
    }

    @Override
    public Account getAccountByNameLogin(String nameLogin) {
        return accountRepository.findByNameLogin(nameLogin,AccountStatus.active.toString());
    }

    @Override
    public GeneralResponse updateImage(ImageRequest request) {
        Account account = accountRepository.findByNameLogin(request.getNameLogin(),AccountStatus.active.toString());
        if (account == null) {
            return new GeneralResponse(false);
        }
        Map<String, Object> map = new HashMap<>();

        map.put("image", request.getImage());
        accountRepository.updateImage(request.getNameLogin(), map);
        return new GeneralResponse(true);
    }

    @Override
    public GeneralResponse register(AccountRegisterRequest registerRequest) {
        Account account = accountRepository.findByNameLogin(registerRequest.getNameLogin(),AccountStatus.active.toString());
        if (account != null) {
            return new GeneralResponse(false, "Tài khoản đã tồn tại!");
        }
        String password = Base64.getEncoder().encodeToString(registerRequest.getPassword().getBytes());

        Account accountNew = new Account();
        accountNew.setNameLogin(registerRequest.getNameLogin());
        accountNew.setPassword(password);
        accountNew.setEmail(registerRequest.getEmail());
        accountNew.setPhoneNumber(registerRequest.getPhoneNumber());
        accountNew.setRole(Role.member);
        accountRepository.save(accountNew);
        return new GeneralResponse(true, "success");
    }
}
