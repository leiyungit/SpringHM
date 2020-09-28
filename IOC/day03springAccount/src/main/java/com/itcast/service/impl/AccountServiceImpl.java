package com.itcast.service.impl;

import com.itcast.dao.IAccountDao;
import com.itcast.domain.Account;
import com.itcast.service.IAccountService;
import com.itcast.utils.TransectionManage;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    // 注入
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private TransectionManage txManage;
    // 注入
    public void setTxManage(TransectionManage txManage) {
        this.txManage = txManage;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            txManage.beginTansection();
            List<Account> accounts = accountDao.findAllAccount();
            txManage.commit();
            return accounts;
        } catch (Exception e) {
            txManage.rollback();
            throw new RuntimeException(e);
        }finally {
            txManage.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            txManage.beginTansection();
            Account account = accountDao.findAccountById(accountId);
            txManage.commit();
            return account;
        } catch (Exception e) {
            txManage.rollback();
            throw new RuntimeException(e);
        }finally {
            txManage.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            txManage.beginTansection();
            accountDao.saveAccount(account);
            txManage.commit();
        } catch (Exception e) {
            txManage.rollback();
            throw new RuntimeException(e);
        }finally {
            txManage.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            txManage.beginTansection();
            accountDao.updateAccount(account);
            txManage.commit();
        } catch (Exception e) {
            txManage.rollback();
            throw new RuntimeException(e);
        }finally {
            txManage.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            txManage.beginTansection();
            accountDao.deleteAccount(accountId);
            txManage.commit();
        } catch (Exception e) {
            txManage.rollback();
            throw new RuntimeException(e);
        }finally {
            txManage.release();
        }

    }

    public void transfer(String sourceName, String targetName, Float money) {
        try {
            // 开启事务
            txManage.beginTansection();
            // 执行操作
            // 1.查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            // 2.查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            // 3.转出账号减少金额
            source.setMoney(source.getMoney()-money);
            // 4.转入账户增加金额
            target.setMoney(target.getMoney()+money);
            // 5.更新转出账户
            accountDao.updateAccount(source);
            int i = 1/0;
            // 6.更新转入账户
            accountDao.updateAccount(target);
            // 提交事务
            txManage.commit();
        } catch (Exception e) {
            // 回滚
            txManage.rollback();
            throw new RuntimeException(e);
        }finally {
            // 释放连接
            txManage.release();
        }

    }
}
