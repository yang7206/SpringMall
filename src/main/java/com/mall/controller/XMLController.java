package com.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/2.
 */
@Controller
public class XMLController {

    @RequestMapping(value = "/hello")
    public String hello(ModelMap modelMap){
        modelMap.addAttribute("message","this is spring mvc");
        return "hello";
    }
}
