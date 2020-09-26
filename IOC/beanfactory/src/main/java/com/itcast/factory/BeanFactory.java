package com.itcast.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties prop;
    private static Map<String,Object> beans;
    /* static {
         try {
             prop = new Properties();
             InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
             //System.out.println(in);
             prop.load(in);
         } catch (Exception e) {
             throw new ExceptionInInitializerError("初始化 properties 失败");
         }
     }*/
    static {
        try {
            prop = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            prop.load(in);

            beans = new HashMap<String, Object>();
            Enumeration<Object> keys = prop.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = prop.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                //System.out.println(key + "=" + value);
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化 properties 失败");
        }
    }

    /**
     * 根据bena的名称获取bean的对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
    /**
     * 根据bena的名称获取bean的对象
     * @param beanName
     * @return
     */
    /*public static Object getBean(String beanName){
        Object bean = null;
        try {
            String path = prop.getProperty(beanName);
            bean = Class.forName(path).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}