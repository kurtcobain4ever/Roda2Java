package com.fan.demo.dao;

import com.fan.demo.po.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;



public class StudentDaoTest {
    StudentDao studentDao;
    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        studentDao=context.getBean(StudentDao.class);
    }
    @Test
    public void doGetAll() {
        List<Student> students= studentDao.getAllStudentBySalary();
        for(Student student:students){
            System.out.println(student);
        }
    }


}