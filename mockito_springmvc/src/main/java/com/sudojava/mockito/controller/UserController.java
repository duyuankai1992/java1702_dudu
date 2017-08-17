package com.sudojava.mockito.controller;

import com.sudojava.mockito.domain.User;
import com.sudojava.mockito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user) {
        boolean flag = userService.login(user);
        if (flag) {
            return "success";
        }else{
            return "fail";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user) {
        boolean flag = userService.addUser(user);
        if (flag) {
            return "success";
        }else{
            return "fail";
        }
    }
}
