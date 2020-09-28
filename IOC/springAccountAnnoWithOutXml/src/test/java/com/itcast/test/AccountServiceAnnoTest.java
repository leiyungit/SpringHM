package com.itcast.test;

import com.itcast.domain.Account;
import com.itcast.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceAnnoTest {

    @Autowired
    private IAccountService accountService;
    @Test
    public void testFindAll(){
//        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService accountService = app.getBean("accountService", IAccountService.class);
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
//        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService accountService = app.getBean("accountService", IAccountService.class);
        accountService.saveAccount(account);
    }
    @Test
    public void testDelete(){

//        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService accountService = app.getBean("accountService", IAccountService.class);
        accountService.deleteAccount(7);
    }
}
