package com.example.day99springboot_jpa.controller;

import com.example.day99springboot_jpa.domain.Product;
import com.example.day99springboot_jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public String find(Model model){
        PageRequest pageRequest = new PageRequest(0,6);
        Page<Product> products = service.findProductPaging(pageRequest);
        for (Product product:products){
            System.out.println(product);
        }
        model.addAttribute("page",products);
        return "success";
    }
}
