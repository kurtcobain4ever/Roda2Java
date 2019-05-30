package com.fan.demo.dao;

import com.fan.demo.po.Student;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface StudentDao {
    List<Student> getAllStudentBySalary();
}
