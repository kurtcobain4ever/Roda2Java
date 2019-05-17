package com.fandemo.service;

import com.fandemo.pojo.po.Title;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class TitleServiceTest {
    TitleService titleService;
    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        titleService=context.getBean(TitleService.class);
    }
    @Test
    public void doGetAll() {
    }

    @Test
    public void doGetById() {
    }

    @Test
    public void doGetUploda() {
    }

    @Test
    public void doGetSetList() {
    }

    @Test
    public void doGetThemeList() {
    }

    @Test
    public void doGetChildList() {
        List<Title> titles=titleService.doGetChildList(5);
        for(Title title:titles){
            System.out.println(title);
        }
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

    @Test
    public void doLoad() {
    }
}