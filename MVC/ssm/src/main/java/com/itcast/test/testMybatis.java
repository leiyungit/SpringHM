package com.itcast.test;

import com.itcast.dao.IAccountDao;
import com.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testMybatis {
    /**
     * 测试查询所有
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        //        加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //        创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //        创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        IAccountDao dao = session.getMapper(IAccountDao.class);
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        session.close();
        in.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void testSave() throws Exception {
        Account account = new Account();
        account.setName("电影院");
        account.setMoney(9d);
        //        加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //        创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //        创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        IAccountDao dao = session.getMapper(IAccountDao.class);
        // 保存
        dao.saveAccount(account);
        // 提交事务
        session.commit();
        session.close();
        in.close();
    }
}
