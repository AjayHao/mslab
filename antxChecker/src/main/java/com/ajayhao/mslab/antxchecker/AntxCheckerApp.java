package com.ajayhao.mslab.antxchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by AjayHao on 2017/6/11.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.ajayhao.mslab.antxchecker" })
public class AntxCheckerApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AntxCheckerApp.class, args);
    }

}