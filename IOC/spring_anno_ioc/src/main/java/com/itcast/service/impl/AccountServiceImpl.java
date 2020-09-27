package com.itcast.service.impl;

import com.itcast.dao.IAccountDao;
import com.itcast.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


// 它的默认值是当前类名，且首字母改小写
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao dao = null;

    public  AccountServiceImpl(){

        System.out.println("AccountServiceImpl 创建了");
    }

    public void savaAccount() {

        dao.sava();
        //System.out.println("111");
    }

    @PostConstruct
    public void inti(){
        System.out.println("init ...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy....");
    }
}
