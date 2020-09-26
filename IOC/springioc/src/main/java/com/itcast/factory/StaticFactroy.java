package com.itcast.factory;

import com.itcast.service.IAccountService;
import com.itcast.service.impl.AccountServiceImpl2;

public class StaticFactroy {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl2();
    }
}
