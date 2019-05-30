package com.fan.demo.service;

import com.fan.demo.po.Account;

public interface AccountService {
    Account doLogin(String username,String password) throws Exception;
    boolean doRegister(Account account);
    Account doGetUserInfo(String username);
}
