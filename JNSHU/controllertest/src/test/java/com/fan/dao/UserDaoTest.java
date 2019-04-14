package com.fan.dao;

import com.fan.pojo.User;
import com.fan.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao;
    @Before
    public void init(){
        ApplicationContext context= new ClassPathXmlApplicationContext("springmvc.xml");
        userDao=context.getBean(UserDao.class);
    }
    @Test
    public void getAllUser() {
        List<User> users= userDao.getAllUser();
        for(User user:users) {
            System.out.println(user);
        }
    }
}