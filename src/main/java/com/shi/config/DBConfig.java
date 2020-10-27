package com.shi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author DaTou
 * @Description
 * @Date 2020/10/21
 **/
@Configuration
public class DBConfig {

    @Resource
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setPassword(dataSourceProperties.getPassword());
        return druidDataSource;
    }

    @Bean
    public DataSourceTransactionManager platformTransactionManager(@Autowired @Qualifier("dataSource")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

//    public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("dataSource")DataSource dataSource){
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource);
//    }

}
