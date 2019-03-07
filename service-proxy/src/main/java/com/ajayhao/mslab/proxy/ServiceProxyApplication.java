package com.ajayhao.mslab.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ServiceProxyApplication
 * <p>
 * TODO
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2018/8/29 15:40
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ServiceProxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProxyApplication.class, args);
    }
}

