package com.ajayhao.mslab.antxchecker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * Created by AjayHao on 2017/6/11.
 */
@EnableOpenApi
@SpringBootApplication
@MapperScan({"com.ajayhao.mslab.**.orm.mapper"})
public class AntxCheckerApp {

    public static void main(String[] args) {
        SpringApplication.run(AntxCheckerApp.class, args);
    }

}