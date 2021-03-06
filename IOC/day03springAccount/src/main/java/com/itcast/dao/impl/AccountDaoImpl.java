package com.itcast.dao.impl;

import com.itcast.dao.IAccountDao;
import com.itcast.domain.Account;

import com.itcast.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {

        this.runner = runner;
    }

    private ConnectionUtils connectionUtils;
    // 注入
    public void setConnectionUtils(ConnectionUtils connectionUtils) {

        this.connectionUtils = connectionUtils;
    }

    @Override
    public List<Account> findAllAccount() {

        try{
            //System.out.println(runner);
            return runner.query(connectionUtils.getThreadConnection(),"select * from account", new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            return runner.query(connectionUtils.getThreadConnection(),"select * from account where id = ?", new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"insert into account(name,money) values(?,?)", account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id = ? ", account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"delete from account  where id = ? ", accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param accountName
     * @return 如果查询到一个用户则返回结果，如果没有则返回null
     *         如果结果集大于1个，则抛出异常
     */
    @Override
    public Account findAccountByName(String accountName) {
        List<Account> list;
        try{
            list = runner.query(connectionUtils.getThreadConnection(),"select * from account where name = ?", new BeanListHandler<Account>(Account.class),accountName);
            if(list == null || list.size() == 0 ){
                return null;
            }else if(list.size()>1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return list.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
