package com.itcast.test;


import com.itcast.service.IAccountService;
import com.itcast.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    @Test
    public void run1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IAccountService accountService = app.getBean("accountService", IAccountService.class);
        accountService.findAll();

    }
}
