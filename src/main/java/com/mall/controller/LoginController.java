package com.mall.controller;

import com.mall.model.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/3/3.
 */
@Controller
public class LoginController extends BaseController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            try {
                User user = (User) authentication.getPrincipal();
                if (user.isEnabled()) {
                    return "personcenter";
                } else {
                    if (!user.isAccountNonLocked()) {
                        return "locked";
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        modelMap.addAttribute("account", new Account());
        return "login";
    }

    @RequestMapping(value = "/personcenter", method = RequestMethod.GET)
    public String personcenter() {

        return "personcenter";
    }

    @RequestMapping(value = "/locked", method = RequestMethod.GET)
    public String locked() {

        return "locked";
    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginAccount(@Valid Account account, BindingResult bindingResult, ModelMap modelMap) throws Exception {
//        if (bindingResult.hasErrors()) {
//            return "login";
//        }
//        Account result = accountService.findAccountByAccountPwd(account.getAccount(), account.getPassword());
//        logger.info(maper.writeValueAsString(result));
//        if (result == null) {
//            return "login";
//        }
//        return "index";
//    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String loginAdmin(ModelMap model) {
        model.addAttribute("title", "Spring Security Hello World");
        model.addAttribute("message", "This is protected page!");
        return "admin";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String loginout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/expired")
    public String expired() {
        return "expiredpages";
    }
}
