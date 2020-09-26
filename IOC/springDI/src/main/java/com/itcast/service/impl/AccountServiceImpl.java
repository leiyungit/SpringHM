package com.itcast.service.impl;

import com.itcast.service.IAccountService;

import java.util.Date;


public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    /*public  AccountServiceImpl(){
        System.out.println("AccountServiceImpl 创建了");
    }*/

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void savaAccount() {

        System.out.println("service save ing...."+name+","+age+","+birthday);
    }
}
