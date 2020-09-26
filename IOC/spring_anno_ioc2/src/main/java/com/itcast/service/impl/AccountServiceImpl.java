package com.itcast.service.impl;

import com.itcast.service.IAccountService;
import org.springframework.stereotype.Component;


// 它的默认值是当前类名，且首字母改小写
@Component
public class AccountServiceImpl implements IAccountService {
    //private IAccountDao dao;

    public  AccountServiceImpl(){

        System.out.println("AccountServiceImpl 创建了");
    }

    public void savaAccount() {

        //dao.sava();
        System.out.println("savaAccount ing");
    }
}
