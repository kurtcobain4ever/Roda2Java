package com.fandemo.dao;

import com.fandemo.pojo.po.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoTest {
    AccountDao accountDao;
    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        accountDao=context.getBean(AccountDao.class);
    }
    @Test
    public void doGetAll() {
    }

    @Test
    public void doGetById() {
        List<Account> accounts=accountDao.doGetAll();
        System.out.println(accounts);
    }

    @Test
    public void doGetByIds() {
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);
        ids.add(5);
       List<Account> accounts=accountDao.doGetByAccountIds(ids);
       for(Account account:accounts){
           System.out.println(account);
       }
    }

    @Test
    public void doLogin() {
        Account account=new Account();
        account.setUsername("admin");
        account.setPassword("admin");
        Account accountx=accountDao.doLogin(account);
        System.out.println(accountx);
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