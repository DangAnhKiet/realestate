package com.estate.real.service.impl;

import com.estate.real.Repository.inf.AccountRepository;
import com.estate.real.document.Account;
import com.estate.real.model.enums.AccountStatus;
import com.estate.real.model.enums.Role;
import com.estate.real.model.enums.StatusLogin;
import com.estate.real.model.request.*;
import com.estate.real.model.response.AccountResponse;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.service.inf.AccountService;
import com.estate.real.utils.MyDate;
import com.estate.real.utils.MyFile;
import com.estate.real.utils.MyWeb3j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    IPFSServiceImpl ipfsService;

    @Override
    public GeneralResponse addAccount(AccountRequest request) {
        Account accountTemp = accountRepository.findByNameLoginAndStatus(request.getNameLogin(), AccountStatus.active.toString());
        if (accountTemp != null) {
            return new GeneralResponse(false, "error-exist");
        }
        Account account = new Account();
        account.setPrivateKey(request.getAddress());
        account.setFullName(request.getFullName());
        account.setNameLogin(request.getNameLogin());
        account.setEmail(request.getEmail());
        account.setGender(request.getGender());
        String password = Base64.getEncoder().encodeToString(request.getPassword().getBytes());
        account.setPassword(password);
        account.setRole(request.getRole());
        account.setStatus(AccountStatus.active);
        account.setPhoneNumber(request.getPhoneNumber());
        account.setPrivateKey(request.getPrivateKey());
        account.setAddress(request.getAddress());
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
    public String login(HttpServletRequest httpServletRequest, AccountLoginRequest accountLoginRequest) {
        System.out.println("++++++++++++++++++++return \"api/account/login");
        Account account = accountRepository.findByNameLoginAndStatus(accountLoginRequest.getNameLogin(), AccountStatus.active.toString());
        if (account == null) {
            return StatusLogin.EXIST_ACCOUNT.toString();
        }
        String passwordRequest = Base64.getEncoder().encodeToString(accountLoginRequest.getPassword().getBytes());
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
        accountResponse.setWalletAddress((account.getAddress() == null) ? "update" : account.getAddress());

        JSONObject jsonAccount = new JSONObject();
        jsonAccount.put("email", accountResponse.getEmail());
        jsonAccount.put("userLogin", accountResponse.getNameLogin());
        jsonAccount.put("fullName", accountResponse.getFullName());
        jsonAccount.put("numberPhone", accountResponse.getPhoneNumber());
        jsonAccount.put("walletAddress", accountResponse.getWalletAddress());
        jsonAccount.put("imgPath", accountResponse.getImg());
        jsonAccount.put("role",accountResponse.getRole().toString());

        @SuppressWarnings("unchecked")
        JSONObject jsonSession = (JSONObject) httpServletRequest.getSession().getAttribute(
                "MY_SESSION");
        if(jsonSession == null){
            jsonSession = new JSONObject();
        }
        jsonSession = jsonAccount;
        if (null != accountResponse.getRole() && Role.admin.toString().contains(accountResponse.getRole().toString())) {
            httpServletRequest.getSession().setAttribute("MY_SESSION", jsonSession.toString());
            return "admin";
        }
        if (null != accountResponse.getRole () && Role.member.toString().contains(accountResponse.getRole().toString())) {
            httpServletRequest.getSession().setAttribute("MY_SESSION", jsonSession.toString());
            System.out.println("++++++++++++++++++++return \"member\";");
            return "member";
        }
        System.out.println("++++++++++++++++++++returnLOCK_ACCOUNT.toString();");
        httpServletRequest.getSession().invalidate();
        return StatusLogin.LOCK_ACCOUNT.toString();
    }

    @Override
    public Account getAccountByNameLogin(String nameLogin) {
        return accountRepository.findByNameLoginAndStatus(nameLogin, AccountStatus.active.toString());
    }

    @Override
    public GeneralResponse updateImage(ImageRequest request) {
        Account account = accountRepository.findByNameLoginAndStatus(request.getNameLogin(), AccountStatus.active.toString());
        if (account == null) {
            return new GeneralResponse(false);
        }
        Map<String, Object> map = new HashMap<>();

        map.put("image", request.getImage());
        accountRepository.updateInformation(request.getNameLogin(), map);
        return new GeneralResponse(true);
    }

    @Override
    public GeneralResponse register(AccountRegisterRequest registerRequest) {
        Account account = accountRepository.findByNameLoginAndStatus(registerRequest.getNameLogin(), AccountStatus.active.toString());
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

    @Override
    public GeneralResponse updatePrivateKey(ChangePrivateKeyRequest request) {
        Account account = accountRepository.findByNameLoginAndRole(request.getNameLogin(), Role.member.toString());
        if (account == null) {
            return new GeneralResponse(false, "error-nameLogin");
        }
        Map<String, Object> updateValues = new HashMap<>();
        if (request.getPrivateKey() != null) {
            String address = MyWeb3j.getAddress(request.getPrivateKey());
            updateValues.put("address", address);
            updateValues.put("privateKey", request.getPrivateKey());
        }
        accountRepository.updateInformation(request.getNameLogin(), updateValues);
        return new GeneralResponse(true);
    }

    @Override
    public GeneralResponse changePassword(ChangePasswordRequest request) {
        Account account = accountRepository.findByNameLoginAndRole(request.getNameLogin(), Role.member.toString());
        if (account == null) {
            return new GeneralResponse(false, "error-nameLogin");
        }
        String passwordOld = Base64.getEncoder().encodeToString(request.getOldPass().getBytes());
        if (account.getPassword().equals(passwordOld)) {
            return new GeneralResponse(false, "error-password");
        }

        Map<String, Object> updateValues = new HashMap<>();
        if (request.getNewPass() != null) {
            String passwordNew = Base64.getEncoder().encodeToString(request.getNewPass().getBytes());
            updateValues.put("password", passwordNew);
        }
        accountRepository.updateInformation(request.getNameLogin(), updateValues);
        return new GeneralResponse(true);
    }

    public static void main(String[] args) {
        String address = "0xB8c77482e45F1F44dE1745F52C74426C631bDD52";
    }
}
