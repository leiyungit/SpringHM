package com.itcast.service.impl;

import com.itcast.service.IAccountService;

/**
 * 账户业务层接口实现类
 */
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("saveAccount ...");
        int i=1/0;
    }

    @Override
    public void updateAccount(Float money) {
        System.out.println("updateAccount ...");
    }

    @Override
    public int countAccount() {
        System.out.println("countAccount ...");
        return 99;
    }
}
