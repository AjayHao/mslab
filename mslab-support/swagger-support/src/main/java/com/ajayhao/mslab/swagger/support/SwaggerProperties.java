package com.ajayhao.mslab.swagger.support;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "swagger.config")
@Setter
@Getter
public class SwaggerProperties {

    private String basePackage;
    private String pathRegex;
    private String title = "Spring Boot中使用Swagger2构建RESTful APIs";
    private String description = "Micro Service Lab,/mslab/stock";
    private String version = "1.0";
}
