//package com.estate.real.controller;
//
//import com.estate.real.document.Account;
//import com.estate.real.model.response.AccountResponse;
//import org.springframework.data.redis.support.collections.DefaultRedisMap;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
////@RestController
//public class SessionController {
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String  login(Model model, HttpSession session){
//        @SuppressWarnings("unchecked")
//        List<String> listUsers = (List<String>) session.getAttribute("MY_SESSION_ACCOUNTS");
//
//        if (listUsers == null) {
//            System.out.println("list null");
//            listUsers = new ArrayList<>();
//        }
//        System.out.println("chay vao get session");
//        for (int i = 0; i < listUsers.size(); i++){
//
//            System.out.println("thanh vien: "+i+" : "+listUsers.get(i) +"-------"+session.getId());
//        }
//        System.out.println("+++++++++++");
//        model.addAttribute("listUsers", listUsers);
//        model.addAttribute("sessionId", session.getId());
////        DefaultRedisMap.entrySet();
//
//        model.addAttribute("role", "admin");
//        return "TestLoginSession";
//    }
//    @RequestMapping(value = "/persistMessage", method = RequestMethod.POST)
//    public String persistMessage(@RequestParam("username") String username,@RequestParam("password") String password, HttpServletRequest request) {
//        @SuppressWarnings("unchecked")
//        List<String> listUsers = (List<String>) request.getSession().getAttribute("MY_SESSION_ACCOUNTS");
//        if (listUsers == null) {
//            listUsers = new ArrayList<>();
//            request.getSession().setAttribute("MY_SESSION_MESSAGES", listUsers);
//        }
//        listUsers.add(username +"--"+password);
//        request.getSession().setAttribute("MY_SESSION_ACCOUNTS", listUsers);
//        System.out.println("chay vao post session");
//        for (int i = 0; i < listUsers.size(); i++){
//
//            System.out.println("thanh vien: "+i+" : "+listUsers.get(i) +"-------"+request.getSession().getId());
//        }
//        System.out.println("+++++++++++");
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
//
//    public String destroySession(HttpServletRequest request){
//
//        request.getSession().invalidate();
//        System.out.println("chay vao destroy session");
//        return "redirect:/";
//    }
//}
