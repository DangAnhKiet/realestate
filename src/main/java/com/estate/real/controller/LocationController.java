package com.estate.real.controller;

import com.estate.real.document.Account;
import com.estate.real.document.Land;
import com.estate.real.service.impl.LandServiceImpl;
import com.estate.real.service.inf.AccountService;
import com.estate.real.service.inf.LandService;
import com.estate.real.utils.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class LocationController {
    @Autowired
    LandService landService;
    @Autowired
    AccountService accountService;

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("checklogin","login thanh cong");
        return "Login";
    }

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public String home(){
        return "Home";
    }

    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String test(){return "Test";}

    @RequestMapping(value={"/member"}, method = RequestMethod.GET)
    public String member(Model model){
        model.addAttribute("listLands", landService.getAllLand());
        return "HomeMember";
    }

    @RequestMapping(value={"/accounts/detail"}, method = RequestMethod.GET)
    public String detailInfo(Model model){
//        model.addAttribute("listLands", landService.getAllLand());
        return "DetailInfo";
    }

    @RequestMapping(value={"/help"}, method = RequestMethod.GET)
    public String help(Model model){
//        model.addAttribute("listLands", landService.getAllLand());
        return "Help";
    }

    @RequestMapping(value={"/admin/manage/land"}, method = RequestMethod.GET)
    public String manageRealOfAdmin(Model model){
        model.addAttribute("listLands",landService.getAllLand());
        return "AdminManageLand";
    }

    @RequestMapping(value={"/admin/land/list"}, method = RequestMethod.GET)
    public String showListLand(Model model){
//        model.addAttribute("listLands",landService.getAllLand());
        return "AdminListLand";
    }

    @RequestMapping(value={"/admin/manage/account"}, method = RequestMethod.GET)
    public String manageAccount(Model model){
//        model.addAttribute("listLands",landService.getAllLand());
        return "AdminManageAccount";
    }

    @RequestMapping(value={"/admin/registry"}, method = RequestMethod.GET)
    public String registry(Model model){
        //Get api key firebase
        String apiKeyFirebase = MyFile.RealFromFile(MyFile.API_KEY_FIREBASE);
//        List<Account> listAccounts = accountService.getAllByStatus()
        if(apiKeyFirebase != null && !apiKeyFirebase.isEmpty()){
            model.addAttribute("apiKeyFirebase",apiKeyFirebase);
        }else{
            model.addAttribute("apiKeyFirebase","");
        }
        return "Registry";
    }

    @RequestMapping(value = {"/admin/home"}, method= RequestMethod.GET)
    public String homeAdmin(){

        return "HomeAdmin";
    }

    @RequestMapping(value = {"/member/lands"}, method = RequestMethod.GET)
    public String memberLands(){
//        List<Land> listLands = landService.getLandsByAddress(address);
        return "LandsMember";
    }

    @RequestMapping(value = {"/admin/land/add"}, method = RequestMethod.GET)
    public String adminAddLand(){
//        List<Land> listLands = landService.getLandsByAddress(address);
        return "AdminAddLand";
    }
}
