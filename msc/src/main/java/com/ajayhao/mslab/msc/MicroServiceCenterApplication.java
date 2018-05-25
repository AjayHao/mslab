package com.ajayhao.mslab.msc;/**
 * Created by AjayHao on 2018/5/25.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName MicroServiceCenterApplication
 * @Description 微服务中心
 * @Author Ajay Hao
 * @Date 2018/5/25 18:59
 * @Version 1.0
 **/
@SpringBootApplication
@EnableConfigServer
public class MicroServiceCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCenterApplication.class, args);
    }
}
