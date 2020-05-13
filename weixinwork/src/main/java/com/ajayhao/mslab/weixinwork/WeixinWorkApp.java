package com.ajayhao.mslab.weixinwork;

import com.ajayhao.mslab.swagger.support.annotation.EnableSwaggerConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * QiyeweixinApp
 * <p>
 * TODO
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2020/5/13 22:53
 */
@SpringBootApplication
@EnableSwaggerConfig
@MapperScan({"com.ajayhao.mslab.**.orm.mapper"})
public class WeixinWorkApp {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(WeixinWorkApp.class, args);
    }

}
