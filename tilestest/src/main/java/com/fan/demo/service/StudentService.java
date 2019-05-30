package com.fan.demo.service;

import com.fan.demo.po.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentService {
    List<Student> doGetStudent();
}
