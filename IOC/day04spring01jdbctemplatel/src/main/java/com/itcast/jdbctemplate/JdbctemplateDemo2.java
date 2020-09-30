package com.itcast.jdbctemplate;

import com.itcast.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbctemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = app.getBean("jdbctemplate", JdbcTemplate.class);
        /*List<Account> list = jt.query("select * from account where money > ?", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setMoney(resultSet.getFloat("money"));
                return account;
            }
        }, 800);*/

        /*List<Account> list = jt.query("select * from account where money > ?", (ResultSet resultSet, int i) -> {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getFloat("money"));
            return account;
        }, 800);*/
        List<Account> list = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 800);
        for (Account account : list) {
            System.out.println(account);
        }

        Integer num = jt.queryForObject("select count(*) from account where money > ?", Integer.class, 200);
        System.out.println(num);

    }
}
