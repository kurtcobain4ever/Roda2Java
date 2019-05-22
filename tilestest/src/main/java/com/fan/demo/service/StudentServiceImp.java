package com.fan.demo.service;

import com.fan.demo.dao.StudentDao;
import com.fan.demo.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentDao studentDao;
    @Autowired
    public List<Student> doGetStudent() {
        return studentDao.getAllStudentBySalary();
    }
}
