package com.mall.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.model.Account;
import com.mall.service.IAccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangxiaoyu on 17/2/25.
 */
@Controller
public class MainController extends BaseController {

    @RequestMapping(value = "/")
    public String index() throws Exception {

        List<Account> accounts = accountService.findAll();
        for (int i = 0; i < accounts.size(); i++) {
            logger.info("--------------------------------------");
            logger.info(maper.writeValueAsString(accounts.get(i)));
            logger.info("--------------------------------------");
        }

        return "index";
    }

    @RequestMapping(value = "/index")
    public String indexAgain() {
        return "index";
    }



    @RequestMapping(value = "/shop")
    public String shop() {
        return "shop";
    }

    @RequestMapping(value = "/checkout")
    public String checkout() {
        return "checkout";
    }

    @RequestMapping(value = "/cart")
    public String cart() {
        return "cart";
    }

    @RequestMapping(value = "/single-product")
    public String singleProduct() {
        return "single-product";
    }

    @RequestMapping("/user")
    public String userInfo(Model model,
                           @RequestParam(value = "name", defaultValue = "Guest") String name) {
        model.addAttribute("name", name);
        if ("admin".equals(name)) {
            model.addAttribute("email", "admin@yiibai.com");
        } else {
            model.addAttribute("email", "Not set");
        }
        return "userinfo";
    }

    @RequestMapping("/back")
    @ResponseBody
    public String backText(Model model,
                           @RequestParam(value = "name", defaultValue = "Guest") String name) {
        return "back :" + name;
    }

    /*
     * Method used to populate the Section list in view.
     * Note that here you can call external systems to provide real data.
     */
    @ModelAttribute("sections")
    public List<String> initializeSections() {

        List<String> sections = new ArrayList<String>();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Research");
        return sections;
    }

    /*
     * Method used to populate the country list in view.
     * Note that here you can call external systems to provide real data.
     */
    @ModelAttribute("countries")
    public List<String> initializeCountries() {

        List<String> countries = new ArrayList<String>();
        countries.add("USA");
        countries.add("CHINA");
        countries.add("FRANCE");
        countries.add("GERMANY");
        countries.add("ITALY");
        countries.add("OTHER");
        return countries;
    }

    /*
     * Method used to populate the subjects list in view.
     * Note that here you can call external systems to provide real data.
     */
    @ModelAttribute("subjects")
    public List<String> initializeSubjects() {
        List<String> subjects = new ArrayList<String>();
        subjects.add("Physics");
        subjects.add("Chemistry");
        subjects.add("Life Science");
        subjects.add("Political Science");
        subjects.add("Computer Science");
        subjects.add("Mathmatics");
        return subjects;
    }


}
