package com.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/3/2.
 */
@Controller
public class RedirectController {

    @RequestMapping(value = "/redirect",method = RequestMethod.GET)
    public String redirect(){
        return "redirect";
    }

    @RequestMapping(value = "/redirect",method = RequestMethod.POST)
    public String redirectToIndex(){
        return "index";
    }

    @RequestMapping(value = "/redirectStatic",method = RequestMethod.POST)
    public String redirectToStatic(){
        return "redirect:/pages/static.html";
    }
}
