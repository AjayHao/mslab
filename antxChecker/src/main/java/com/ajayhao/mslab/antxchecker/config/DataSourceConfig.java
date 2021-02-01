package com.ajayhao.mslab.antxchecker.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * DataSourceConfig
 * <p>
 * TODO
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2020/10/29 19:38
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean("masterDataSource")
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }


    @Bean("secondaryDataSource")
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }
}
