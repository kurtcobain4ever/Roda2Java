package com.fan.demo.service;

import com.fan.demo.po.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class AccountServiceImpTest {
    AccountService accountService;
    @Before
    public void init(){
    ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
    accountService=context.getBean(AccountService.class);
    }
    @Test
    public void doLogin() {
    }

    @Test
    public void doRegister() {
    }

    @Test
    public void doGetUserInfo() {
        Account account=accountService.doGetUserInfo("admin");
        System.out.println(account);
    }
}