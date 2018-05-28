package com.ajayhao.mslab.stock;

import com.ajayhao.mslab.swagger.support.annotation.EnableSwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by AjayHao on 2017/6/11.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
//@ComponentScan(basePackages = { "com.ajayhao.mslab.stock" })
@EnableSwaggerConfig
public class StockApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StockApp.class, args);
    }

}