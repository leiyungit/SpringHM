package com.itcast.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbctemplateDemo1 {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///springdb");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource);
        System.out.println(jt);
        jt.execute("insert into account(name,money) values('fff',200)");

    }
}
