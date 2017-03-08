package com.mall.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.controller.MainController;
import com.mall.model.Account;
import com.mall.service.IAccountService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class AccountTest {

    @Resource
    IAccountService accountService;
    public static final Logger logger = Logger.getLogger(MainController.class);

    private static final ObjectMapper maper = new ObjectMapper();

    @Test
    public void findAll() throws Exception {
        List<Account> accounts = accountService.queryForList();
        for (int i = 0; i < accounts.size(); i++) {
            logger.info("--------------------------------------");
            logger.info(maper.writeValueAsString(accounts.get(i)));
            logger.info("--------------------------------------");
        }
    }

    @Test
    public void findAccount() throws Exception {
        Account result = accountService.findAccountByAccountPwd("yang", "yangpwd");
        logger.info("--------------------------------------");
        logger.info(maper.writeValueAsString(result));
        logger.info("--------------------------------------");
    }

    @Test
    public void findAccountByAccount() throws Exception {
        Account account = accountService.findAccountByAccount("admin");
        logger.info("--------------------------------------");
        logger.info(maper.writeValueAsString(account));
        logger.info("--------------------------------------");
    }
}
