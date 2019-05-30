package com.fan.demo.controller;

import com.fan.demo.po.Account;
import com.fan.demo.po.Profession;
import com.fan.demo.po.Student;
import com.fan.demo.service.AccountService;
import com.fan.demo.service.ProfessionService;
import com.fan.demo.service.StudentService;
import com.fan.demo.util.DESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class PageController {
    @Autowired
    StudentService studentService;
    @Autowired
    ProfessionService professionService;
    @Autowired
    AccountService accountService;

    //首页
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String getAllStudent(ModelMap modelMap){
        List<Student> students=studentService.doGetStudent();
        students.subList(0,4);
        modelMap.addAttribute("students",students);
        return "home";
    }

    //职业
    @RequestMapping(value = "/u/profession",method = RequestMethod.GET)
    public String getAllProfeesion(ModelMap modelMap){
        List<Profession> professions=professionService.getAllProfession();
        modelMap.addAttribute("professions",professions);
        return "profession";
    }

    //登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLogin(){
        return "login";
    }
    @RequestMapping(value = "/loginx",method = RequestMethod.POST)
    public String doLogin(@RequestParam("username")String username,@RequestParam("password")String password,
                          HttpServletResponse response,ModelMap modelMap) throws Exception {
        Account account=accountService.doLogin(username,password);
        if(account!=null){
            String value=account.getId()+"/"+account.getNickname();
            String token=DESUtil.desEncript(value);
            Cookie cookie=new Cookie("token",token);
            cookie.setMaxAge(60*60*24*10);
            cookie.setPath("/");
            response.addCookie(cookie);
            modelMap.addAttribute("account",account);
            return "redirect:/home";
        }
        return "result";
    }
    //注册
    @RequestMapping(value = "/register",method =RequestMethod.GET)
    public String getRegister(){
        return "register";
    }
    @RequestMapping(value= "/registerx",method = RequestMethod.POST)
    public String doRegister(@RequestParam("username")String username,@RequestParam("password")String password,
                             @RequestParam("nickname")String nickname) throws Exception {
        Account account=new Account();
        account.setUsername(username);
        account.setNickname(nickname);
        account.setPassword(DESUtil.desEncript(password));
        account.setCreate_at(System.currentTimeMillis());
        if(accountService.doRegister(account)){
            return "redirect:/home";
        }
        return "result";
    }
    //登出
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies)
        {
            if(cookie.getName().equals("token")) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return "redirect:/home";
    }
    @RequestMapping(value = "/result",method = RequestMethod.GET)
    public String errorResult(){
        return "result";
    }
}
