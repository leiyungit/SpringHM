package com.itcast.test;

import com.itcast.domain.Account;
import com.itcast.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {
    @Test
    public void testFindAll(){
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = app.getBean("accountService", IAccountService.class);
        //System.out.println(accountService);
        List<Account> list = accountService.findAllAccount();
        //System.out.println(list.size());
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
