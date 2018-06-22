package com.ajayhao.mslab.stock.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by AjayHao on 2018/2/17.
 */
@Component
@ConfigurationProperties(prefix = "juhe.service")
@Data
public class RemoteConfig {
    private String juheKey;
    private String juheServiceUrl;
}
