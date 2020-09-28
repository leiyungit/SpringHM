package com.itcast.test;

import com.itcast.domain.Account;
import com.itcast.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceAnnoTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindAll(){

        List<Account> list = accountService.findAllAccount();
        for (Account e : list) {
            System.out.println(e);
        }
    }
    @Test
    public void testSave(){
        Account account  = new Account();
        account.setName("eee");
        account.setMoney(1234.0f);

        accountService.saveAccount(account);
    }
    @Test
    public void testDelete(){


        accountService.deleteAccount(5);
    }
}
