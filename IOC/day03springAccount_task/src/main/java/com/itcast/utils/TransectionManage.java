package com.itcast.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 事务处理
 */
@Component
@Aspect  // 表示当前类是一个切面类
public class TransectionManage {

    @Autowired
    private ConnectionUtils connectionUtils;
//    // 注入
//    public void setConnectionUtils(ConnectionUtils connectionUtils) {
//        this.connectionUtils = connectionUtils;
//    }

    @Pointcut("execution(* com.itcast.service.*..*(..))")
    private void pt1(){};

    @Before("pt1()")
    public void beginTansection(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @AfterReturning("pt1()")
    public void commit(){
        try {
            System.out.println("commit....");
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @AfterThrowing("pt1()")
    public void rollback(){
        try {
            System.out.println("rollback....");
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @After("pt1()")
    public void release(){
        try {
            System.out.println("After....");
            connectionUtils.getThreadConnection().close(); // 归还到连接池
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
