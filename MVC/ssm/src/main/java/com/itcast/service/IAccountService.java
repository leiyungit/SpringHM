package com.itcast.service;

import com.itcast.domain.Account;

import java.util.List;

/**
 * 业务层接口
 */
public interface IAccountService {
    // 查询所有账户
    List<Account> findAll();
    // 保存账户
    void saveAccount(Account account);
}
