package com.sudojava.mockito.controller;

import com.sudojava.mockito.domain.Todos;
import com.sudojava.mockito.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(Todos todos) {
        ModelAndView modelAndView = new ModelAndView();
        boolean flag = todoService.add(todos);
        if (flag) {
            modelAndView.setViewName("/success");
            modelAndView.addObject("msg", "OK");
        } else {
            modelAndView.setViewName("/fail");
            modelAndView.addObject("msg", "FAIL");
        }
        return modelAndView;
    }


    //指定地址栏传递参数
    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        boolean flag = todoService.delete(id);
        if (flag) {
            modelAndView.setViewName("/deletesuccess");
            modelAndView.addObject("msg", "delete success!!");
        } else {
            modelAndView.setViewName("/deletefail");
            modelAndView.addObject("msg", "delete fail!!");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ModelAndView find(String title) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("----title-->>"+title);
        List<Todos> list = todoService.findByTitle(title);
        if (null != list && !list.isEmpty()) {
            modelAndView.setViewName("/findsuccess");
            modelAndView.addObject("list", list);
        } else {
            modelAndView.setViewName("/fail");
            modelAndView.setStatus(HttpStatus.NO_CONTENT);
        }
        return modelAndView;
    }


}
