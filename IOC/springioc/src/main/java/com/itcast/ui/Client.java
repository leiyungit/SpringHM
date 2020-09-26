package com.itcast.ui;

import com.itcast.service.IAccountService;
import com.itcast.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

    /**
     *
     * 获取spring的IOC核心容器，并根据id获取对象
     *
     * ApplicationContext： 使用场景：单例对象适用    更多使用此接口
     * 它在构建核心容器时，创建对象采取的策略是采用立即加载的方式，也就是一读取配置文件马上就创建对象
     * BeanFactory：使用场景：多例对象适用
     * 它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式，也就是什么时候根据id获取对象时创建
     *
     * @param args
     */
    public static void main(String[] args) {
//        IAccountService service = new AccountServiceImpl();
//        service.savaAccount();


//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        System.out.println(ac);
//        IAccountService ser = (IAccountService) ac.getBean("accountService");


        //-----------------BeanFactory
//        Resource resource =new ClassPathResource("bean.xml");
//        BeanFactory fac = new XmlBeanFactory(resource);
//        IAccountService ser = (IAccountService)fac.getBean("accountService");
//
//        System.out.println(ser);
        // ser.savaAccount();

        //createBean2();
        scope();
    }

    public static void createBean2(){
        ClassPathXmlApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService ser = (IAccountService) as.getBean("accountService");
        ser.savaAccount();
    }

    public static void scope(){
        ClassPathXmlApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService ser = (IAccountService) as.getBean("accountService");
        IAccountService ser2 = (IAccountService) as.getBean("accountService");

        System.out.println(ser == ser2);

    }
}
