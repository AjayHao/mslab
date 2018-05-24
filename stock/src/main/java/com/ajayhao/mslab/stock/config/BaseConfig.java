package com.ajayhao.mslab.stock.config;

import com.ajayhao.mslab.core.util.JsonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * Created by AjayHao on 2018/2/17.
 */
@Configuration
public class BaseConfig {

    @Bean("restTemplate")
    RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().clear();
        //write application/x-www-form-urlencoded request
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        //read and write application/json
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter(JsonUtil.JsonObjectMapperFactory.getInstance()));
        return restTemplate;
    }
}
