package com.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(path="/hello")
    public String sayShow(){
        System.out.println("hello spring mvc");
        return  "success";
    }
}
