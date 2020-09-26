package com.itcast.service.impl;

import com.itcast.dao.IAccountDao;
import com.itcast.service.IAccountService;

public class AccountServiceImpl2 implements IAccountService {

    public AccountServiceImpl2(String name){
        System.out.println("AccountServiceImpl2 创建了   带参数" );
    }
    public AccountServiceImpl2(){
        System.out.println("AccountServiceImpl2 创建了");
    }
    @Override
    public void savaAccount() {

        System.out.println("server中的savaAccount方法执行了。。。。");
    }
}
