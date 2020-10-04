package com.itcast.controller;

import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping(path = "/saveUser", method = {RequestMethod.POST} )
    public String saveUser(User user){
        System.out.println("执行了....");
        System.out.println(user);
        return "success";
    }
}
