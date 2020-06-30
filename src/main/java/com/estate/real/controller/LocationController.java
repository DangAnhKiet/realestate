package com.estate.real.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
public class LocationController {
    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("checklogin","login thanh cong");
        return "Login";
    }

    @RequestMapping(value={"/admin-manage"}, method = RequestMethod.GET)
    public String manageRealOfAdmin(){
        return "ManageReal";
    }
}
