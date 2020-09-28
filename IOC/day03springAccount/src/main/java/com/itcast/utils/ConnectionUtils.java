package com.itcast.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类，用于从数据库中获取一个连接，并且实现和线程的绑定
 */
public class ConnectionUtils {

    /**
     * 这个类提供线程局部变量。 这些变量与其正常的对应方式不同，因为访问一个的每个线程（通过其get或set方法）都有自己独立初始化的变量副本。 ThreadLocal实例通常是希望将状态与线程关联的类中的私有静态字段（例如，用户ID或事务ID）。
     * 例如，下面的类生成每个线程本地的唯一标识符。 线程的ID在第一次调用ThreadId.get()时被分配，并在后续调用中保持不变。
     */
    private ThreadLocal<Connection> tl = new ThreadLocal();

    private DataSource dataSource;
    // 注入
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public Connection getThreadConnection(){
        try {
            Connection conn = tl.get();
            if(conn == null){
               conn = dataSource.getConnection();
               tl.set(conn);
            }
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void removeConnection(){
        tl.remove();
    }

}
