package com.fandemo.service;

import com.fandemo.pojo.po.Account;

import java.util.List;


public interface AccountService {
    List<Account> doGetAll();
    List<Account> doGetById(int id);
    List<Account> doGetIdList(List<Integer> ids);
    Account doLogin(Account account);
    boolean doSetPassword(String password,int id);
    boolean doUpdate(Account account);
    boolean doCreate(Account account);
    boolean doDelete(int id);
}