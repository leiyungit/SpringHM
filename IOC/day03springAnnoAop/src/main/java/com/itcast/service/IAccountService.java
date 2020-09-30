package com.itcast.service;

/**
 * 账户 业务层接口
 */
public interface IAccountService {
    void saveAccount();
    void updateAccount(Float money);
    int countAccount();
}
