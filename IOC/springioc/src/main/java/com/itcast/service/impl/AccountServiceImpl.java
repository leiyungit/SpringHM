package com.itcast.service.impl;

import com.itcast.dao.IAccountDao;
import com.itcast.dao.impl.AccountDaoImpl;
import com.itcast.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    //IAccountDao dao = new AccountDaoImpl();
    private IAccountDao dao;

    public  AccountServiceImpl(){
        System.out.println("AccountServiceImpl 创建了");
    }
    @Override
    public void savaAccount() {

        dao.sava();
    }
}
