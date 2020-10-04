package com.itcast.controller;

import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @RequestMapping(path="/testString")
    public String testString(Model model){
        System.out.println("testString 执行了.....");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUname("数据库");
        user.setAge(21);
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Date parse = df.parse("2020/11/11");
        //user.setDate(new Date());
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView();

        System.out.println("testModelAndView 执行了.....");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUname("数据库2");
        //user.setAge(21);
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Date parse = df.parse("2020/11/11");
        //user.setDate(new Date());
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
       @RequestMapping(path="/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect 。。。。");
        //return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/index.jsp";
    }

    /*@RequestMapping("/testAjax")
    public void testAjax(@RequestBody String body){
        System.out.println("testAjax 。。。。");
        System.out.println(body);

    }*/
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax 。。。。");
        System.out.println(user);
       // 模拟数据库查询，作响应
        user.setUname("四大名著");
        user.setAge(800);
        user.setDate(new Date());
        // 做响应
        return  user;
    }

    @RequestMapping("/testAjax2")
    public void testAjax3(@RequestBody String body){
        System.out.println("testAjax2 。。。。");
        System.out.println(body);
    }

    @RequestMapping("/testAjax3")
    public void testAjax3(@RequestBody User user){
        System.out.println("testAjax3。。。。");
        System.out.println(user);
    }
}
