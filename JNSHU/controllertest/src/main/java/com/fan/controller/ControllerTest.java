package com.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerTest {
    @RequestMapping("/hello")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest,
                                      javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("userlist");
        return mav;
    }

    @RequestMapping("/no")
    public @ResponseBody String handleString(javax.servlet.http.HttpServletRequest httpServletRequest,
                                      javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {

        String str="llllllllll";
        return str;
    }
}
