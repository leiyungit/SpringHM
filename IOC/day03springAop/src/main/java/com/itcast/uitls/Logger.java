package com.itcast.uitls;

import org.aspectj.lang.ProceedingJoinPoint;
/**
 * 工具类，记录日志通知
 */
public class Logger {

    /**
     * 打印日志，计划在切入点方法执行前执行
     */
    public void befer(){

        System.out.println("Logger类befer 开始记录日志....");
    }
    public void afterReturn(){

        System.out.println("Logger类 afterReturn....");
    }
    public void afterThrow(){

        System.out.println("Logger类 afterThrow....");
    }
    public void after(){

        System.out.println("Logger类 after....");
    }
    public Object around(ProceedingJoinPoint pjp)throws Throwable {
        Object rtValue=null;
        try {
            System.out.println("环绕通知.....前置");
            rtValue =  pjp.proceed(pjp.getArgs());
            System.out.println("环绕通知.....后置   ==>"+rtValue);
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知.....异常");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕通知.....最终");
        }
    }
}
