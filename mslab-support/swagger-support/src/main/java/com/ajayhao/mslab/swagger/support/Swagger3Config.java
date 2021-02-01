package com.ajayhao.mslab.swagger.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName Swagger3Config
 * @Description swagger配置类
 * @Author Ajay Hao
 * @Date 2020/10/29 17:19
 * @Version 1.0
 **/

@Configuration
public class Swagger3Config {

    @Autowired
    private SwaggerProperties properties;

    @Bean
    public Docket createRestApi() {

        ApiSelectorBuilder apis = new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getBasePackage()))
                .paths(PathSelectors.any());
        return apis.build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .version(properties.getVersion())
                .build();
    }

}
