package com.fan.controller;

import com.fan.pojo.User;
import com.fan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/a")
public class MyController {
    @Autowired
    UserService userService;
    int code;
    //查询全部
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String getUser(ModelMap modelMap) {
        try{
            List<User> users = userService.getAllUser();
            if(users.size()!=0){
                code=0;
                modelMap.addAttribute("users",users);
                modelMap.addAttribute("code",code);
                return "userlist";
            }else{
                code=-101;
                modelMap.addAttribute("code",code);
                return "result";
            }
        }catch (Exception e){
            code=-1000;
            modelMap.addAttribute("code",code);
            return "result";
        }
    }
    @RequestMapping(value = "/student/page",method = RequestMethod.GET)
    public String getUsersInPage(@RequestParam(value = "page",required = false,defaultValue = "0")int page ,
                                 @RequestParam(value = "size",required = false,defaultValue = "0")int size,ModelMap modelMap){
        try{
            List <User> users=userService.getPage(page,size);
            code=0;
            modelMap.addAttribute("code",code);
            modelMap.addAttribute("users",users);
            return "userlist";
        }catch (Exception e) {
            code = -1000;
            modelMap.addAttribute("code",code);
            return "result";
        }
    }
    //查询id
    @RequestMapping(value = "/student/id",method = RequestMethod.GET)
    public String getUserById(@RequestParam("min") int min,ModelMap modelMap) {
        try{
            List<User> users = userService.getUserById(min-1,min+1);
            if(users.size()>0){
                code= 0;
                modelMap.addAttribute("code", code);
                modelMap.addAttribute("users",users);
                return "userlist";
            }else{
                code=-101;
                modelMap.addAttribute("code",code);
                return "result";
            }
        }catch (Exception e){
            code=-400;
            modelMap.addAttribute("code",code);
            return "result";
        }
    }
    //新增
    @RequestMapping(value = "/studentadd",method = RequestMethod.GET)
    public ModelAndView addPage(){
        ModelAndView mav=new ModelAndView("add");
        return mav;
    }
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String createUser(@RequestParam("name")String name,@RequestParam("age")int age,ModelMap modelMap){
        User user=new User();
        user.setAge(age);
        user.setName(name);
        if(user.getAge()!=0&&user.getName()!=null){
        code=userService.insertUser(user)?0:-300;
        modelMap.addAttribute("code",code);
        return "result";
    }else{
            code=-300;
            modelMap.addAttribute("code",code);
            return "result";
        }
    }
    //修改
    @RequestMapping(value = "/studentput/{id}",method = RequestMethod.GET)
    public ModelAndView updatePage(@PathVariable("id")int id){
        User user=userService.getUserById(id-1,id+1).get(0);
        ModelAndView mav=new ModelAndView("update","usertoput",user);
        return mav;
    }
    @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id")int id,@RequestParam("name") String name,@RequestParam("age")int age,ModelMap modelMap){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        code=userService.updateUser(user)?0:-500;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //删除
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") int id,ModelMap modelMap){
        code=userService.deleteUser(id)?0:-200;
        modelMap.addAttribute("code",code);
        return "result";
    }
//    @RequestMapping(value = "/error/{code}",method = RequestMethod.GET)
//    public ModelAndView error(@PathVariable("code") int code){
//        System.out.println("bb---------------------------bbbbbbbbb");
//        ModelAndView mav=new ModelAndView("result","code",code);
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa------------------aaaaaaaaaaaaa");
//        return mav;
//    }
}


