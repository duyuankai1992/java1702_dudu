package com.sudojava.spring.controller;

import com.sudojava.spring.domain.Todos;
import com.sudojava.spring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addTodo(Todos todos){
        boolean flag = todoService.addUser(todos);
        ModelAndView modelAndView = new ModelAndView();
        if (flag){
           modelAndView.addObject("msg","OK");
           modelAndView.setViewName("/success");
        }else{
            modelAndView.addObject("msg","FAIL");
            modelAndView.setViewName("/fail");
        }
        return  modelAndView;
    }
}
