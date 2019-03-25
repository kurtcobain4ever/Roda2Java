package com.fan.dao;

import com.fan.pojo.Stu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class StuDaoTest {
    StuDao stuDao;
    StuDao stuDao0;
    @Before
    public void init(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        stuDao=(StuDao)context.getBean("stuDao");
        stuDao0=(StuDao)context.getBean("stuDao0");
    }
    @Test
    public void doCreate() {
        Stu stu=new Stu();
        stu.setName("小王");
        stu.setQq(6666666);
        stu.setMajor("JAVA");
        stu.setGraduate("MIT");
        stu.setReportlink("www.baidu.com");
        stu.setWish("学不会就胖10斤");
        stu.setCreate_at(System.currentTimeMillis());
        try{
            stuDao.doCreate(stu);
            System.out.println(stu);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void doCreate1() {
        List<Stu> stus=new ArrayList<Stu>();
        for(int i=0;i<100;i++){
            Stu stu=new Stu();
            stu.setName("啦啦啦");
            stu.setQq(1000100+i);
            stu.setMajor("JAVA");
            int a=(int)Math.random()*5;
            HashMap<Integer,String> grad=new HashMap<>();
            grad.put(0,"华中科技大学");
            grad.put(1,"哈弗");
            grad.put(2,"湖南大学");
            grad.put(3,"四川大学");
            grad.put(4,"北京大学");
            stu.setGraduate(grad.get(a));
            stu.setReportlink("www.baidu.com");
            stu.setWish("学不会就胖10斤");
            stu.setCreate_at(System.currentTimeMillis());
            stus.add(stu);
        }
        try{
            stuDao.doCreate1(stus);
        }catch (Exception e){
            System.out.println("连接异常");
            e.printStackTrace();
        }
    }

    @Test
    public void doUpdate() {
        Stu stu=new Stu();
        stu.setId(2);
        stu.setName("小王");
        stu.setQq(999999);
        stu.setMajor("WEB");
        stu.setGraduate("湖南大学");
        stu.setReportlink("www.4399.com");
        stu.setWish("学不会就胖10斤");
        stu.setUpdate_at(System.currentTimeMillis());
        try{
            stuDao.doUpdate(stu);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void doRemove() {
        try{
            stuDao.doRemove(3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void queryById() {
        try{
            System.out.print(stuDao.queryById(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void queryAll() {
        try{
            List<Stu> stus=stuDao.queryAll();
            for(Stu stu:stus) {
                System.out.println(stu);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Test
    public void doCreate0() {
        Stu stu=new Stu();
        stu.setName("萨满");
        stu.setQq(2000000);
        stu.setMajor("UI");
        stu.setGraduate("QQQ");
        stu.setReportlink("www.JNSHU.com");
        stu.setWish("IN ME THE TIGER ,SNIFF THE ROSE");
        stu.setCreate_at(System.currentTimeMillis());
        try{
            stuDao0.doCreate(stu);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void doCreate10() {
        List<Stu> stus=new ArrayList<Stu>();
        for(int i=0;i<100;i++){
            Stu stu=new Stu();
            stu.setName("狗儿子");
            stu.setQq(666600+i);
            stu.setMajor("JAVA");
            HashMap<Integer,String> grad=new HashMap<>();
            grad.put(0,"华中科技大学");
            grad.put(1,"哈弗");
            grad.put(2,"湖南大学");
            grad.put(3,"四川大学");
            grad.put(4,"北京大学");
            int a=(int)Math.random()*5;
            stu.setGraduate(grad.get(a));
            stu.setReportlink("www.腾讯.com");
            stu.setWish("狗带");
            stu.setCreate_at(System.currentTimeMillis());
            stus.add(stu);
        }
        try{
            stuDao0.doCreate1(stus);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void doUpdate0() {
        Stu stu=new Stu();
        stu.setId(4);
        stu.setName("隔壁老王");
        stu.setQq(666999);
        stu.setMajor("WEB");
        stu.setGraduate("野鸡大学");
        stu.setReportlink("www.dailyfuck.com");
        stu.setWish("搞快去死");
        stu.setUpdate_at(System.currentTimeMillis());
        try{
            stuDao0.doUpdate(stu);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void doRemove0() {
        try {
            stuDao0.doRemove(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void queryById0() {
        try {
            stuDao0.queryById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void queryAll0() {
        try {
            for(Stu stu:stuDao0.queryAll()){
                System.out.println(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}