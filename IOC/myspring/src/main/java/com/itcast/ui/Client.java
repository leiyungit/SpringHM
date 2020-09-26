package com.itcast.ui;

import com.itcast.factory.BeanFactory;
import com.itcast.service.IAccountService;
import com.itcast.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
        //IAccountService service = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            IAccountService service = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(service);
            service.savaAccount();

        }

    }
}
