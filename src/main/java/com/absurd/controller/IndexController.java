package com.absurd.controller;

import com.absurd.model.User;
import com.absurd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2016/5/19.
 */
@RestController
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(@RequestParam String username,@RequestParam String password) {
        boolean islog = userService.login(username,password);
        if(islog)
        return "登录成功!欢迎："+username;
        else
            return "登录失败";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam String username,@RequestParam String password) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        boolean isreg = userService.register(u);
        if(isreg)
            return "注册成功!欢迎："+username;
        else
            return "注册失败";
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getAll(){
       return userService.getAll();
    }

}
