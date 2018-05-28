package com.ajayhao.mslab.stock.config;

import com.ajayhao.mslab.core.util.JsonUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * Created by AjayHao on 2018/2/17.
 */
@Component
@ConfigurationProperties(prefix = "juheData")
@Data
public class RemoteConfig {
    private String juheKey;
    private String juheServiceUrl;
}
