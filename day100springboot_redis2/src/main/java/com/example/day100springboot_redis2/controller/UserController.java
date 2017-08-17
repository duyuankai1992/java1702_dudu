package com.example.day100springboot_redis2.controller;

import com.example.day100springboot_redis2.domain.User;
import com.example.day100springboot_redis2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.soap.SOAPBinding;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addUser(User user){
        service.addUser(user);
        return "success";
    }

    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public String findAllUser(){
        Iterable<User> list = service.findAll();
        for (User user : list){
            System.out.println(user);
        }
        return "success";
    }

    @RequestMapping(value = "/findName",method = RequestMethod.GET)
    public String findName(String name){
        Page<User> list = service.findByName(name,new PageRequest(0,4));
        for (User user : list){
            System.out.println(user);
        }
        return "success";
    }
}
