package com.mall.service;

import com.mall.model.Account;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */
public interface IAccountService {

    List<Account> findAll();
    List<Account> queryForList();

    Account findAccountByAccountPwd(String account,String password);
    Account findAccountByAccount(String account);

}
