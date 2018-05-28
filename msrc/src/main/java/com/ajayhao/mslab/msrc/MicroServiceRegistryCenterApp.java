package com.ajayhao.mslab.msrc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName MicroServiceRegistryCenterApp
 * @Description 微服务注册中心
 * @Author Ajay Hao
 * @Date 2018/5/28 12:45
 * @Version 1.0
 **/

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceRegistryCenterApp {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceRegistryCenterApp.class, args);
    }
}
