package com.fandemo.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;



public class AccountServiceTest {
    AccountService accountService;
    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        accountService=context.getBean(AccountService.class);
    }
    @Test
    public void doGetAll() {
    }

    @Test
    public void doGetById() {
    }

    @Test
    public void doGetIdList() {
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);
        ids.add(5);
        System.out.println(ids);
        accountService.doGetIdList(ids);
    }

    @Test
    public void doLogin() {

    }

    @Test
    public void doUpdate() {
    }

    @Test
    public void doCreate() {
    }

    @Test
    public void doDelete() {
    }
}