package com.itcast.uitls;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 工具类，记录日志通知
 */
@Component
@Aspect  // 表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* com.itcast.service.*..*(..))")
    private void pt1(){};
    /**
     * 打印日志，计划在切入点方法执行前执行
     */
    @Before("execution(* com.itcast.service.*..*(..))")
    public void befer(){

        System.out.println("Logger类befer 开始记录日志....");
    }
    @AfterReturning("pt1()")
    public void afterReturn(){

        System.out.println("Logger类 afterReturn.... 后置");
    }
    @AfterThrowing("pt1()")
    public void afterThrow(){

        System.out.println("Logger类 afterThrow....");
    }
    @After("pt1()")
    public void after(){

        System.out.println("Logger类 after.... 最终");
    }
    @Around("pt1()")
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
