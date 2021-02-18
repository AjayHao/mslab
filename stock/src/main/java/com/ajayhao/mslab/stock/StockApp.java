package com.ajayhao.mslab.stock;

import com.ajayhao.mslab.swagger.support.annotation.EnableSwaggerConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;

/**
 * Created by AjayHao on 2021/2/18.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwaggerConfig
@MapperScan("com.ajayhao.mslab.**.orm.mapper")
public class StockApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StockApp.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource ();
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(new ArrayList<String>(){{add("*");}});
        configuration.setAllowedHeaders(new ArrayList<String>(){{add("*");}});
        configuration.setAllowedMethods(new ArrayList<String>(){{add("*");}});
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }

}