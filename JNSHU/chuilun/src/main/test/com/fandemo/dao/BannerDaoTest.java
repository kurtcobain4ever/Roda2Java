package com.fandemo.dao;

import com.fandemo.pojo.po.Banner;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BannerDaoTest {
    BannerDao bannerDao;
    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        bannerDao=context.getBean(BannerDao.class);
    }
    @Test
    public void doGetAll() {
        List<Banner> banners= bannerDao.doGetAll();
        for(Banner banner:banners){
            System.out.println(banner);
        }
    }

    @Test
    public void doGetById() {
    }

    @Test
    public void doGetUploda() {
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