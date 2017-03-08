package com.mall.service.impl;

import com.mall.dao.AccountMapper;
import com.mall.model.Account;
import com.mall.service.IAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by Administrator on 2017/2/28.
 */
@Service("accountService")
@Transactional
public class AccountServiceImpl implements IAccountService {

    private static final AtomicLong atomicLong = new AtomicLong();

    @Resource
    AccountMapper accountMapper;

    static {
    }

    public List<Account> findAll() {
        return accountMapper.getAllUser();
    }

    @Override
    public List<Account> queryForList() {
        return accountMapper.queryForList();
    }

    public Account findAccountByAccountPwd(String account,String password){
        return accountMapper.findAccountByAccountPwd(account, password);
    }

    @Override
    public Account findAccountByAccount(String account) {
        return accountMapper.findAccountByAccount(account);
    }

}
