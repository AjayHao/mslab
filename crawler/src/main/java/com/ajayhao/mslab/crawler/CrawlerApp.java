package com.ajayhao.mslab.crawler;

import com.ajayhao.mslab.swagger.support.annotation.EnableSwaggerConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName MicroServiceCenterApplication
 * @Description 微服务配置中心
 * @Author Ajay Hao
 * @Date 2018/5/25 18:59
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableSwaggerConfig
@MapperScan("com.ajayhao.mslab.**.orm.mapper")
public class CrawlerApp {
    public static void main(String[] args) {
        SpringApplication.run(CrawlerApp.class, args);
    }
}
