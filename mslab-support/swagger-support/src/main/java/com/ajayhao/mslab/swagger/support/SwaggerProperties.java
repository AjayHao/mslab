package com.ajayhao.mslab.swagger.support;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "swagger.config")
@Data
@RefreshScope
public class SwaggerProperties {
    private String basePackage;
    private String title;
    private String description;
    private String version;
}
