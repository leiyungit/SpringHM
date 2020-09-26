package com.itcast.service.impl;

import com.itcast.dao.IAccountDao;
import com.itcast.factory.BeanFactory;
import com.itcast.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    //IAccountDao dao = new AccountDaoImpl();
    //private IAccountDao dao = (IAccountDao) BeanFactory.getBean("accountDao"); // map单例模式 不可以在此声明
    private int i = 1;
    @Override
    public void savaAccount() {
        IAccountDao dao = (IAccountDao) BeanFactory.getBean("accountDao");
        dao.sava();
        System.out.println(i++);
    }
}
