package com.itcast.factory;

import com.itcast.service.IAccountService;
import com.itcast.service.impl.AccountServiceImpl2;

public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl2();
    }
}
