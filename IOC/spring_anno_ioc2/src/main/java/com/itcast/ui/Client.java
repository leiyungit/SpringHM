package com.itcast.ui;

import com.itcast.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        //IAccountService ser = (IAccountService) app.getBean("accountServiceImpl");
        Object ser = app.getBean("accountServiceImpl");
        System.out.println(ser);
    }
}
