package com.fan.service;

import com.fan.dao.UserDao;
import com.fan.pojo.User;
import javafx.application.Application;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService;
    @Before
    public void init(){
        ApplicationContext context= new ClassPathXmlApplicationContext("springmvc.xml");
        userService=context.getBean(UserService.class);
    }
    @Test
    public void getAllUserTest() {
        List<User> users= userService.getAllUser();
        for(User user:users) {
            System.out.println(user);
        }
    }
//    @Test
//    public void deleteUserTest(){
//        boolean a=userService.deleteUser(22);
//        System.out.println(a);
//    }
    @Test
    public void insertUserTest(){
        User user=new User();
        user.setAge(1111);
        user.setName("kurt");
        userService.insertUser(user);
    }
    @Test
    public void updateUserTest(){
        User user=new User();
        int id;
        id=59160;
        user.setName("水电费007");
        user.setId(id);
        user.setAge(999);
        userService.updateUser(user);
    }
}