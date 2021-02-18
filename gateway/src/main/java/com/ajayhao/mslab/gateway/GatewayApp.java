package com.ajayhao.mslab.gateway;

import com.ajayhao.mslab.swagger.support.annotation.EnableSwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * GatewayApp
 * <p>
 * TODO
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2021/2/18 17:45
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableSwaggerConfig
public class GatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }

}
