package com.sibyl.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @Classname DataSourceConfig
 * @Description TODO
 * @Date 2021/8/21 22:24
 * @Created by dyingleaf3213
 */
public class DataSourceConfig {
    /**
     * 数据源
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
