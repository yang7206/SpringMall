package com.mall.controller;

import com.mall.model.Account;
import com.mall.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
@RestController
public class RestMainController {

    @Autowired
    IAccountService accountService;

    @RequestMapping(value = "/account",method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findAll(){
        List<Account> accounts =accountService.findAll();
        if(accounts.isEmpty()){
            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
    }

}
