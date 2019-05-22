package com.fan.demo.controller;

import com.fan.demo.po.Profession;
import com.fan.demo.po.Student;
import com.fan.demo.service.ProfessionService;
import com.fan.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    StudentService studentService;
    @Autowired
    ProfessionService professionService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String getAllStudent(ModelMap modelMap){
        List<Student> students=studentService.doGetStudent();
        students.subList(0,4);
        modelMap.addAttribute("students",students);
        return "home";
    }
    @RequestMapping(value = "/profession",method = RequestMethod.GET)
    public String getAllProfeesion(ModelMap modelMap){
        List<Profession> professions=professionService.getAllProfession();
        modelMap.addAttribute("professions",professions);
        return "profession";
    }
}
