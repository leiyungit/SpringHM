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
        for (Account e : list) {
            System.out.println(e);
        }
    }
    @Test
    public void testSave(){
        Account account  = new Account();
        account.setName("eee");
        account.setMoney(1234.0f);
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = app.getBean("accountService", IAccountService.class);
        accountService.saveAccount(account);
    }
    @Test
    public void testDelete(){

        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = app.getBean("accountService", IAccountService.class);
        accountService.deleteAccount(7);
    }
}
