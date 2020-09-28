package com.itcast.factory;

import com.itcast.service.IAccountService;
import com.itcast.utils.TransectionManage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {

    private IAccountService accountService;

    private TransectionManage txManage;
    // 注入
    public void setTxManage(TransectionManage txManage) {

        this.txManage = txManage;
    }

    public final void setAccountService(IAccountService accountService) {

        this.accountService = accountService;
    }
    public IAccountService getAccountService() {
        return Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            System.out.println("proxy....");
                            txManage.beginTansection();
                            rtValue = method.invoke(accountService, args);
                            txManage.commit();
                            return rtValue;
                        } catch (Exception e) {
                            txManage.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            txManage.release();
                        }
                    }
                });
    }


}
