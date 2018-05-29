package com.ajayhao.mslab.mscc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName MicroServiceCenterApplication
 * @Description 微服务配置中心
 * @Author Ajay Hao
 * @Date 2018/5/25 18:59
 * @Version 1.0
 **/
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class MicroServiceConfigCenterApp {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConfigCenterApp.class, args);
    }
}
