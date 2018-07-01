package com.ajayhao.mslab.crawler;

import com.ajayhao.mslab.swagger.support.annotation.EnableSwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

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
public class CrawlerApp {
    public static void main(String[] args) {
        SpringApplication.run(CrawlerApp.class, args);
    }
}
