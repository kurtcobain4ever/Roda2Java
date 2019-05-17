package com.fandemo.dao;

import com.fandemo.pojo.po.Works;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class WorksDaoTest {
    WorksDao worksDao;
    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        worksDao=context.getBean(WorksDao.class);
    }
    @Test
    public void doGetList() {
        List<Works> worksList=worksDao.doGetList(2,0,10);
        for(Works works:worksList){
            System.out.println(works);
        }
    }

    @Test
    public void searchTest() {
        List<Works> worksList=worksDao.doSearch("的",0,10);;
    }
}