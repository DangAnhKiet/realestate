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
////@Controller
////@RestController
//
//@RestController
//@RequestMapping(value = "api/session")
//public class SessionController {
//    @RequestMapping(value = "/update", method = RequestMethod.GET)
//    public String  updateSession(Model model, HttpSession session){
//        @SuppressWarnings("unchecked")
//       HttpSession newSession = session;
//        if(newSession != null){
//            String strTemp = (String) newSession.getAttribute("MY_SESSION");
//            System.out.println(strTemp);
//        }
//        return "TestLoginSession";
//    }
//
//}
