package com.ajayhao.simpleboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by AjayHao on 2017/6/11.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.ajayhao.simpleboot" })
public class SimpleBootApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SimpleBootApp.class, args);
    }

}