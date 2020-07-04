package com.estate.real.controller;

import com.estate.real.service.impl.LandServiceImpl;
import com.estate.real.service.inf.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
public class LocationController {
    @Autowired
    LandService landService;

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("checklogin","login thanh cong");
        return "Login";
    }

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public String home(){
        return "Home";
    }

    @RequestMapping(value={"/member"}, method = RequestMethod.GET)
    public String member(){
        return "HomeMember";
    }

    @RequestMapping(value={"/admin-manage"}, method = RequestMethod.GET)
    public String manageRealOfAdmin(Model model){
        model.addAttribute("listLands",landService.getAllLand());
        return "ManageReal";
    }
}
