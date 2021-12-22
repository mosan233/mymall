package com.sf.mymall.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "登陆",description = "登陆授权相关操作")
@Controller
public class HelloController {

    @RequestMapping("/home")
    public String home(){
        System.out.println("enter home...");
        return "home";
    }

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("enter hello...");
        return "hello";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("enter login...");
        return "login";
    }
}
