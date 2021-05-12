package springdemo.jdbc.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
// 组件扫描
@ComponentScan(basePackages = "springdemo.jdbc")
// 开启事务
@EnableTransactionManagement
// AOP
@EnableAspectJAutoProxy
public class SpringConfig {

    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/mytest?serverTimezone=Asia/Shanghai");
        ds.setUsername("root");
        ds.setPassword("mariadb");
        return ds;
    }

    /**
     * 事务管理器
     * PlatformTransactionManager是 父接口
     * 使用 jdbcTemplate或MyBatis时,使用DataSourceTransactionManager实现类
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        PlatformTransactionManager manager = new DataSourceTransactionManager(dataSource);
        return manager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }


}
