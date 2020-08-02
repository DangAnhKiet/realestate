package com.estate.real.controller;

import com.estate.real.document.History;
import com.estate.real.document.Land;
import com.estate.real.model.enums.Role;
import com.estate.real.model.response.LandResponse;
import com.estate.real.service.inf.AccountService;
import com.estate.real.service.inf.LandService;
import com.estate.real.utils.MyFile;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LocationController {
    @Autowired
    LandService landService;
    @Autowired
    AccountService accountService;

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(HttpServletRequest servletRequest) {
        servletRequest.getSession().invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model, HttpSession session) {
        System.out.println("++++++++++++++++++++vao /login location");
        @SuppressWarnings("unchecked")
        String strSession = (String) session.getAttribute("MY_SESSION");
        if (strSession == null) {
            strSession = "";
        } else {
            if (!strSession.isEmpty()) {
                JSONObject jsonObject = new JSONObject(strSession);
                if (jsonObject.has("role")) {
                    if (jsonObject.getString("role").contains(Role.admin.toString())) {
                        return "redirect:/";
                    }
                    if (jsonObject.getString("role").contains(Role.member.toString())) {
                        return "redirect:/";
                    }
                }
            }
        }
        System.out.println("++++++++++++++++++++return \"Login\";");
        return "Login";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request) {
        String strSession = (String) request.getSession().getAttribute("MY_SESSION");

        List<LandResponse> landResponseList = landService.getAllLand();
        if (landResponseList != null && landResponseList.size() > 0) {
            model.addAttribute("landResponseList", landResponseList);
        }
        if (strSession == null || strSession.isEmpty()) {
            return "Home";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.member.toString())) {
                    model.addAttribute("role", Role.member.toString());
                    return "Home";
                }
                if (jsonSession.getString("role").contains(Role.admin.toString())) {
                    model.addAttribute("role", Role.admin.toString());
                    return "Home";
                }
            }
            request.getSession().invalidate();
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/land/{id}"}, method = RequestMethod.GET)
    public String landDetail(Model model,@PathVariable("id")int id)
    {
        LandResponse landResponse = landService.getLandById(id);
        if(landResponse !=null) {
            model.addAttribute("isNull", false);
            model.addAttribute("landResponse", landResponse);
            String valueEth = accountService.getETHFromVND(landResponse.getPrice());
            model.addAttribute("valueEth", valueEth);
            model.addAttribute("addressHolder", landResponse.getAddressSeller());
            model.addAttribute("landId", landResponse.getLandId());
        } else {
            model.addAttribute("isNull", true);
        }

        return "LandDetail";
    }

    @RequestMapping(value = {"/landn/{id}"}, method = RequestMethod.GET)
    public String landDetailNew(Model model, @PathVariable("id") int id) {
        LandResponse landResponse = landService.getLandById(id);
        if (landResponse != null) {
            model.addAttribute("isNull", false);
            model.addAttribute("landResponse", landResponse);
        } else {
            model.addAttribute("isNull", true);
        }

        return "LandDetailNew";
    }

    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String test() {
        return "Test";
    }

    @RequestMapping(value = {"/not-found"}, method = RequestMethod.GET)
    public String notFound() {
        return "NotFound";
    }

    @RequestMapping(value = {"/accounts/detail"}, method = RequestMethod.GET)
    public String detailInfo(Model model, HttpServletRequest httpServletRequest) {
        @SuppressWarnings("unchecked")
        String strSession = (String) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.admin.toString())) {
                    model.addAttribute("role", Role.admin.toString());
//                    model.addAttribute("listLands", landService.getAllLand());
                    return "DetailInfo";
                }
                if (jsonSession.getString("role").contains(Role.member.toString())) {
                    model.addAttribute("role", Role.member.toString());
//                    model.addAttribute("listLands", landService.getAllLand());
                    return "DetailInfo";
                }
            }
            httpServletRequest.getSession().invalidate();
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/transaction"}, method = RequestMethod.POST)
    public String transactionBuy(Model model, HttpServletRequest httpServletRequest) {
        @SuppressWarnings("unchecked")
        String strSession = (String) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.admin.toString())) {
                    httpServletRequest.getSession().invalidate();
                    return "redirect:/login";
                }
                if (jsonSession.getString("role").contains(Role.member.toString())) {
                    model.addAttribute("role", Role.member.toString());
//                    model.addAttribute("listLands", landService.getAllLand());
                    return "Transaction";
                }
            }
            httpServletRequest.getSession().invalidate();
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/admin/help"}, method = RequestMethod.GET)
    public String help(Model model, HttpServletRequest httpServletRequest) {
        String strSession = (String) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.admin.toString())) {
                    model.addAttribute("role", Role.admin.toString());
//                    model.addAttribute("listLands", landService.getAllLand());
                    return "AdminHelp";
                }
            }
            httpServletRequest.getSession().invalidate();
            return "redirect:/not-found";
        }

    }

    @RequestMapping(value = {"/member/help"}, method = RequestMethod.GET)
    public String memberHelp(Model model, HttpServletRequest httpServletRequest) {
        String strSession = (String) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.member.toString())) {
                    model.addAttribute("role", Role.member.toString());
//                    model.addAttribute("listLands", landService.getAllLand());
                    return "MemberHelp";
                }
            }
            httpServletRequest.getSession().invalidate();
            return "redirect:/not-found";
        }

    }

    @RequestMapping(value = {"/member/manage/history"}, method = RequestMethod.GET)
    public String memberManageHistory(Model model, HttpServletRequest httpServletRequest) {
        String strSession = (String) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.member.toString())) {
                    model.addAttribute("role", Role.member.toString());
                    List<History> list = accountService.getListHistory(jsonSession.getString("userLogin"));
                    model.addAttribute("listLands", list);
                    return "MemberManageHistory";
                }
            }
            httpServletRequest.getSession().invalidate();
            return "redirect:/not-found";
        }

    }

    @RequestMapping(value = {"/admin/manage/land"}, method = RequestMethod.GET)
    public String manageRealOfAdmin(Model model, HttpServletRequest httpServletRequest) {
        String strSession = (String) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.admin.toString())) {
                    model.addAttribute("role", Role.admin.toString());
//                    model.addAttribute("listLands", landService.getAllLand());
                    return "AdminManageLand";
                }
            }
            httpServletRequest.getSession().invalidate();
            return "redirect:/not-found";
        }

    }

    @RequestMapping(value = {"/member/manage/land"}, method = RequestMethod.GET)
    public String manageRealOfMember(Model model, HttpServletRequest httpServletRequest) {
        String strSession = (String) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            List<Land> lands = landService.getAllLandByAddressHolder(jsonSession.get("walletAddress").toString());
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.member.toString())) {
                    model.addAttribute("role", Role.member.toString());
                    model.addAttribute("listLands", lands);
                    return "MemberManageLand";
                }
            }
            httpServletRequest.getSession().invalidate();
            return "redirect:/not-found";
        }

    }

    @RequestMapping(value = {"/admin/land/list"}, method = RequestMethod.GET)
    public String showListLand(Model model, HttpServletRequest httpServletRequest) {
        String strSession = (String) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.admin.toString())) {
                    model.addAttribute("role", Role.admin.toString());
//                    model.addAttribute("listLands", landService.getAllLand());
                    return "AdminListLand";
                }
            }
            httpServletRequest.getSession().invalidate();
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/admin/manage/account"}, method = RequestMethod.GET)
    public String manageAccount(Model model, HttpServletRequest httpServletRequest) {
        String strSession = (String) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.admin.toString())) {
                    model.addAttribute("role", Role.admin.toString());
//                    model.addAttribute("listLands", landService.getAllLand());
                    return "AdminManageAccount";
                }
            }
            httpServletRequest.getSession().invalidate();
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/admin/account/registry"}, method = RequestMethod.GET)
    public String registry(Model model, HttpServletRequest httpServletRequest) {
        String strSession = (String) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.admin.toString())) {
                    model.addAttribute("role", Role.admin.toString());
                    //Get api key firebase
                    String apiKeyFirebase = MyFile.RealFromFile(MyFile.API_KEY_FIREBASE);
                    if (apiKeyFirebase != null && !apiKeyFirebase.isEmpty()) {
                        model.addAttribute("apiKeyFirebase", apiKeyFirebase);
                    } else {
                        model.addAttribute("apiKeyFirebase", "");
                    }
                    return "AdminRegistry";
                }
            }
            httpServletRequest.getSession().invalidate();
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/member/home"}, method = RequestMethod.GET)
    public String member(Model model, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        String strSession = (String) request.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.member.toString())) {
                    model.addAttribute("role", Role.member.toString());
                    return "Home";
                }
            }
            request.getSession().invalidate();
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/admin/exchanges"}, method = RequestMethod.GET)
    public String exchangeForAdmin(Model model, HttpServletRequest request) {
        String strSession = (String) request.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.admin.toString())) {
                    model.addAttribute("role", Role.admin.toString());
                    return "AdminExchanges";
                }
            }
            request.getSession().invalidate();
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/member/exchanges"}, method = RequestMethod.GET)
    public String exchangeForMember(Model model, HttpServletRequest request) {
        String strSession = (String) request.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.member.toString())) {
                    model.addAttribute("role", Role.member.toString());
                    return "Home";
                }
            }
            request.getSession().invalidate();
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/admin/home"}, method = RequestMethod.GET)
    public String homeAdmin(Model model, HttpServletRequest request) {
        String strSession = (String) request.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.admin.toString())) {
                    model.addAttribute("role", Role.admin.toString());
                    return "AdminHome";
                }
            }
            request.getSession().invalidate();
            return "redirect:/not-found";
        }
    }

    @RequestMapping(value = {"/member/lands"}, method = RequestMethod.GET)
    public String memberLands() {
//        List<Land> listLands = landService.getLandsByAddress(address);
        return "LandsMember";
    }

    @RequestMapping(value = {"/admin/land/add"}, method = RequestMethod.GET)
    public String adminAddLand(Model model, HttpServletRequest httpServletRequest) {
        String strSession = (String) httpServletRequest.getSession().getAttribute("MY_SESSION");
        if (strSession == null || strSession.isEmpty()) {
            return "redirect:/login";
        } else {
            JSONObject jsonSession = new JSONObject(strSession);
            if (jsonSession.has("role")) {
                if (jsonSession.getString("role").contains(Role.admin.toString())) {
                    model.addAttribute("role", Role.admin.toString());
                    return "AdminAddLand";
                }
            }
            httpServletRequest.getSession().invalidate();
            return "redirect:/not-found";
        }
    }
}
