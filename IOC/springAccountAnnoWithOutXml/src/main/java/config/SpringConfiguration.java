package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 *ComponentScan 中 basePackages  等同于 value
 *  <context:component-scan base-package="com.itcast"></context:component-scan>
 */
@Configuration
@ComponentScan("com.itcast")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
