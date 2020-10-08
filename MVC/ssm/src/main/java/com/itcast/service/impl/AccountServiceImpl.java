package com.itcast.service.impl;

import com.itcast.dao.IAccountDao;
import com.itcast.domain.Account;
import com.itcast.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public List<Account> findAll() {
        System.out.println(" 业务层 findAll 执行了...");

        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println(" 业务层 saveAccount 执行了...");
    }
}
