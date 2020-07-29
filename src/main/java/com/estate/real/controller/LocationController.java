package com.estate.real.controller;

import com.estate.real.contanst.Session;
import com.estate.real.model.enums.Role;
import com.estate.real.service.inf.AccountService;
import com.estate.real.service.inf.LandService;
import com.estate.real.utils.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

@Controller
public class LocationController {
    @Autowired
    LandService landService;
    @Autowired
    AccountService accountService;

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(HttpServletRequest servletRequest){
        servletRequest.getSession().invalidate();
        return "redirect:/";
    }
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        HashSet<String> hsetSession = (HashSet<String>) session.getAttribute("MY_SESSION");
        if (hsetSession == null) {
            hsetSession = new HashSet<>();
        } else {
            for (String i : hsetSession) {
                if (i.contains(Session.ACCOUNT_LOGIN)) {
                    String[] arrTemp = i.split("-");
                    if (arrTemp.length >= 3) {
                        String role = arrTemp[2];
                        if (role.contains(Role.admin.toString())) {
                            model.addAttribute("listLands", landService.getAllLand());
                            model.addAttribute("MY_SESSION", hsetSession);
                            return "redirect:/admin/home";
                        }
                        if (role.contains(Role.member.toString())) {
                            model.addAttribute("listLands", landService.getAllLand());
                            model.addAttribute("MY_SESSION", hsetSession);
                            return "redirect:/member/home";
                        }
                    }
                    return "redirect:/not-found";
                }
            }
            model.addAttribute("MY_SESSION", hsetSession);
        }
        return "Login";
    }

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public String home(){
        return "Home";
    }

    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String test() {
        return "Test";
    }

    @RequestMapping(value = {"/not-found"}, method = RequestMethod.GET)
    public String notFound() {
        return "NotFound";
    }

    @RequestMapping(value = {"/member/home"}, method = RequestMethod.GET)
    public String member(Model model, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        HashSet<String> hsetSession = (HashSet<String>) request.getSession().getAttribute("MY_SESSION");

        if (hsetSession != null) {
            System.out.println("===list session");
            for (String i : hsetSession) {
                System.out.println(i);
            }
            System.out.println(request.getSession().getId());
            System.out.println("======");
        }

        if (hsetSession == null) {
            return "redirect:/login";
        } else {
            for (String i : hsetSession) {
                if (i.contains(Session.ACCOUNT_LOGIN)) {
                    String[] arrTemp = i.split("-");
                    if (arrTemp.length >= 3) {
                        String role = arrTemp[2];
                        if (role.contains(Role.member.toString())) {
                            model.addAttribute("listLands", landService.getAllLand());
                            return "MemberHome";
                        }
                    }
                    return "redirect:/not-found";
                }
            }
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/accounts/detail"}, method = RequestMethod.GET)
    public String detailInfo(Model model,HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        HashSet<String> hsetSession = (HashSet<String>) request.getSession().getAttribute("MY_SESSION");
        if (hsetSession == null) {
            return "redirect:/login";
        } else {
            for (String i : hsetSession) {
                if (i.contains(Session.ACCOUNT_LOGIN)) {
                    String[] arrTemp = i.split("-");
                    if (arrTemp.length >= 3) {
                        String role = arrTemp[2];
                        if (role.contains(Role.member.toString())) {
                            model.addAttribute("listLands", landService.getAllLand());
                            return "DetailInfo";
                        }
                        if (role.contains(Role.admin.toString())) {
                            model.addAttribute("listLands", landService.getAllLand());
                            return "DetailInfo";
                        }
                    }
                    return "redirect:/not-found";
                }
            }
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/help"}, method = RequestMethod.GET)
    public String help(Model model) {
//        model.addAttribute("listLands", landService.getAllLand());
        return "Help";
    }

    @RequestMapping(value = {"/admin/manage/land"}, method = RequestMethod.GET)
    public String manageRealOfAdmin(Model model) {
        model.addAttribute("listLands", landService.getAllLand());
        return "AdminManageLand";
    }

    @RequestMapping(value = {"/admin/land/list"}, method = RequestMethod.GET)
    public String showListLand(Model model) {
//        model.addAttribute("listLands",landService.getAllLand());
        return "AdminListLand";
    }

    @RequestMapping(value = {"/admin/manage/account"}, method = RequestMethod.GET)
    public String manageAccount(Model model) {
//        model.addAttribute("listLands",landService.getAllLand());
        return "AdminManageAccount";
    }

    @RequestMapping(value = {"/admin/account/registry"}, method = RequestMethod.GET)
    public String registry(Model model) {
        //Get api key firebase
        String apiKeyFirebase = MyFile.RealFromFile(MyFile.API_KEY_FIREBASE);
//        List<Account> listAccounts = accountService.getAllByStatus()
        if (apiKeyFirebase != null && !apiKeyFirebase.isEmpty()) {
            model.addAttribute("apiKeyFirebase", apiKeyFirebase);
        } else {
            model.addAttribute("apiKeyFirebase", "");
        }
        return "AdminRegistry";
    }

    @RequestMapping(value = {"/admin/home"}, method = RequestMethod.GET)
    public String homeAdmin(Model model, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        HashSet<String> hsetSession = (HashSet<String>) request.getSession().getAttribute("MY_SESSION");
        if (hsetSession != null) {
            System.out.println("===list session");
            for (String i : hsetSession) {
                System.out.println(i);
            }
            System.out.println(request.getSession().getId());
            System.out.println("======");
        }

        if (hsetSession == null) {
            return "redirect:/login";
        } else {
            for (String i : hsetSession) {
                if (i.contains(Session.ACCOUNT_LOGIN)) {
                    String[] arrTemp = i.split("-");
                    if (arrTemp.length >= 3) {
                        String role = arrTemp[2];
                        if (role.contains(Role.admin.toString())) {
                            model.addAttribute("listLands", landService.getAllLand());
                            return "AdminHome";
                        }
                    }
                    return "redirect:/not-found";
                }
            }
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/member/lands"}, method = RequestMethod.GET)
    public String memberLands() {
//        List<Land> listLands = landService.getLandsByAddress(address);
        return "LandsMember";
    }

    @RequestMapping(value = {"/admin/land/add"}, method = RequestMethod.GET)
    public String adminAddLand() {
//        List<Land> listLands = landService.getLandsByAddress(address);
        return "AdminAddLand";
    }
}
