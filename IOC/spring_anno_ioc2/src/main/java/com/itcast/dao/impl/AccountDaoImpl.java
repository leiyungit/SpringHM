package com.itcast.dao.impl;

import com.itcast.dao.IAccountDao;
import org.springframework.stereotype.Repository;

//@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    public AccountDaoImpl(){
        System.out.println("AccountDaoImpl 创建了");
    }
    @Override
    public void sava() {
        System.out.println("sava account....");
    }
}
