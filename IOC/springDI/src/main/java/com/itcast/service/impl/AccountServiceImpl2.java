package com.itcast.service.impl;

import com.itcast.service.IAccountService;

import java.util.Date;


public class AccountServiceImpl2 implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void savaAccount() {

        System.out.println("service save ing...."+name+","+age+","+birthday);
    }
}
