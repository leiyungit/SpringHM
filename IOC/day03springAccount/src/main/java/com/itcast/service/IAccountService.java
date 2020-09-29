package com.itcast.service;

import com.itcast.domain.Account;

import java.util.List;

/**
 * 业务层接口
 */
public interface IAccountService {

    List<Account> findAllAccount();
    Account findAccountById(Integer accountId);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
    void transfer(String sourceName, String targetName, Float money);
}
