package com.ajayhao.mslab.lambdalab;

import com.ajayhao.mslab.swagger.support.annotation.EnableSwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;

/**
 * Created by AjayHao on 2017/6/11.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableSwaggerConfig
public class LambdaLabApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LambdaLabApp.class, args);
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