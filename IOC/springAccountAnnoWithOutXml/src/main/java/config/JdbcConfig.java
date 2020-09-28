package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class JdbcConfig
{
    @Value("${jdbc.classdriver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("runner")
    @Scope("prototype") // 多例
    public QueryRunner createQueryRunner(@Qualifier("dataSource") DataSource dataSource){

        return new QueryRunner(dataSource);
    }

    @Bean(name="dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource pool = new ComboPooledDataSource();
        try {

            pool.setDriverClass(driver);
            pool.setJdbcUrl(url);
            pool.setUser(username);
            pool.setPassword(password);

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return pool;
    }
}
