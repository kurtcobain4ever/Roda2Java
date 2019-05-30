package com.fan.demo.service;

import com.fan.demo.dao.AccountDao;
import com.fan.demo.po.Account;
import com.fan.demo.util.DESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImp implements AccountService {
    @Autowired
    AccountDao accountDao;
    @Override
    public Account doLogin(String username,String pwd)throws Exception {
        String password=DESUtil.desEncript(pwd);
        return accountDao.doLogin(username,password);
    }
    @Override
    public boolean doRegister(Account account){
        if(accountDao.doGetByUsername(account.getUsername())==null){
            return accountDao.doRegister(account);
        }
        return false;
    }
    @Override
    public Account doGetUserInfo(String username){
        return accountDao.doGetByUsername(username);
    }
}
