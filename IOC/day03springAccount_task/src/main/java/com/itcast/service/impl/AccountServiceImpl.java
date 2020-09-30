package com.itcast.service.impl;

import com.itcast.dao.IAccountDao;
import com.itcast.domain.Account;
import com.itcast.service.IAccountService;
import com.itcast.utils.TransectionManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
            return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
           return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
            accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
            accountDao.deleteAccount(accountId);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer...");
        // 1.查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        // 2.查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        // 3.转出账号减少金额
        source.setMoney(source.getMoney() - money);
        // 4.转入账户增加金额
        target.setMoney(target.getMoney() + money);
        // 5.更新转出账户
        accountDao.updateAccount(source);
        // int i = 1/0;
        // 6.更新转入账户
        accountDao.updateAccount(target);

    }
}
