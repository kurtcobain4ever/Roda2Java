package com.fan.controller;

import com.fan.pojo.Result;
import com.fan.pojo.ResultUser;
import com.fan.pojo.User;
import com.fan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.util.List;


@Controller
@RequestMapping("/a")
public class MyController {
    @Autowired
    UserService userService;
    @Autowired
    Result result;
    @Autowired
    ResultUser resultUser;
    @Autowired
    MessageSource messageSource;
    @Autowired
    User user;
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
    @ResponseBody
    @RequestMapping(value = "/student1",method = RequestMethod.GET)
    public ResultUser getUser1(ModelMap modelMap) {
        try{
            List<User> users = userService.getAllUser();
            if(users.size()!=0){
                String codex="0";
                resultUser.setCode(Integer.parseInt(codex));
                resultUser.setMessage(messageSource.getMessage(codex,null,null));
                resultUser.setData(users);
                return resultUser;
            }else{
                String codex="-101";
                resultUser.setCode(Integer.parseInt(codex));
                resultUser.setMessage(messageSource.getMessage(codex,null,null));
                return resultUser;
            }
        }catch (Exception e){
            String codex="-1000";
            resultUser.setCode(Integer.parseInt(codex));
            resultUser.setMessage(messageSource.getMessage(codex,null,null));
            return resultUser;
        }
    }

    //分页查询
    @RequestMapping(value = "/student/page",method = RequestMethod.GET)
    public String getUsersInPage(@RequestParam(value = "page",required = false,defaultValue = "1")int page ,
                                 @RequestParam(value = "size",required = false,defaultValue = "10")int size,ModelMap modelMap){
        try{
            List <User> users=userService.getPage(page,size);
            code=0;
            modelMap.addAttribute("users",users);
            modelMap.addAttribute("code",code);
            return "userlist";
        }catch (Exception e) {
            code = -1000;
            modelMap.addAttribute("code",code);
            return "result";
        }
    }
    //查询id
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") int id,ModelMap modelMap) {
        try{
            List<User> users = userService.getUserById(id-1,id+1);
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
    //直接返回对象，spring将其转化为json
    @ResponseBody
    @RequestMapping(value = "/student1/{id}",method = RequestMethod.GET)
    public ResultUser getUserById1(@PathVariable ("id") int id,ModelMap modelMap) {
        try{
            List<User> users = userService.getUserById(id-1,id+1);
            if(users.size()>0){
                String codex="0";
                resultUser.setCode(Integer.parseInt(codex));
                resultUser.setMessage(messageSource.getMessage(codex,null,null));
                resultUser.setData(users);
                return resultUser;
            }else{
                String codex="-101";
                resultUser.setCode(Integer.parseInt(codex));
                resultUser.setMessage(messageSource.getMessage(codex,null,null));
                resultUser.setData(users);
                return resultUser;
            }
        }catch (Exception e){
            String codex="-400";
            resultUser.setCode(Integer.parseInt(codex));
            resultUser.setMessage(messageSource.getMessage(codex,null,null));
            return resultUser;
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

    //直接用spring返回对象，spring自动转化为json
    @ResponseBody
    @RequestMapping(value = "/student1",method = RequestMethod.POST)
    public Result createUser1(@RequestParam("name")String name,@RequestParam("age")int age,ModelMap modelMap){
        user.setAge(age);
        user.setName(name);
        if(user.getAge()!=0&&user.getName()!=null){
            String codex=userService.insertUser(user)?"0":"-300";
            result.setCode(Integer.parseInt(codex));
            result.setMessage(messageSource.getMessage(codex,null,null));
            return result;
        }else{
            String codex="-300";
            result.setCode(Integer.parseInt(codex));
            result.setMessage(messageSource.getMessage(codex,null,null));
            return result;
        }
    }

    //修改
    @RequestMapping(value = "/studentput/{id}",method = RequestMethod.GET)
    public ModelAndView updatePage(@PathVariable("id")int id){
        User user=userService.getUserById(id-1,id+1).get(0);
        ModelAndView mav=new ModelAndView("update","usertoput",user);
        return mav;
    }

    //修改方法一
    @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id")int id,@RequestParam("name") String name,@RequestParam("age")int age,ModelMap modelMap){
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        code=userService.updateUser(user)?0:-500;
        modelMap.addAttribute("code",code);
        return "result";
    }

    //修改方法二
    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public String updateUser(@RequestBody User userx,ModelMap modelMap){
        user.setId(userx.getId());
        user.setName(userx.getName());
        user.setAge(userx.getAge());
        code=userService.updateUser(user)?0:-500;
        modelMap.addAttribute("code",code);
        return "result";
    }

    //修改方法三，直接使用spring返回对象，spring将对象转化为json
    @ResponseBody
    @RequestMapping(value = "/student1/{id}",method = RequestMethod.PUT)
    public Result updateUser1(@PathVariable("id")int id,@RequestParam("name") String name,@RequestParam("age")int age,ModelMap modelMap){
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        String codex=userService.updateUser(user)?"0":"-500";
        result.setCode(Integer.parseInt(codex));
        result.setMessage(messageSource.getMessage(codex,null,null));
        return result;
    }
    //删除
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") int id,ModelMap modelMap){
        code=userService.deleteUser(id)?0:-200;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //直接用spring返回josn的删除
    @ResponseBody
    @RequestMapping(value = "/student1/{id}",method = RequestMethod.DELETE)
    public Result deleteUser1(@PathVariable("id") int id,ModelMap modelMap){
        String codex=userService.deleteUser(id)?"0":"-200";
        result.setCode(Integer.parseInt(codex));
        result.setMessage(messageSource.getMessage(codex,null,null));
        return result;
    }
}


