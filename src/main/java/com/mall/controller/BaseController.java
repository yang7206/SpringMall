package com.mall.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.service.IAccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2017/3/3.
 */
@Controller
public class BaseController {

    public static final Logger logger = Logger.getLogger(MainController.class);
    protected static final ObjectMapper maper = new ObjectMapper();

    @Autowired
    IAccountService accountService;

}
