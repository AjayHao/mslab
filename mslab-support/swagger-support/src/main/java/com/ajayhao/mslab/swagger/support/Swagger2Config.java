package com.ajayhao.mslab.swagger.support;

import com.google.common.base.Predicates;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @ClassName Swagger2Config
 * @Description swagger配置类
 * @Author Ajay Hao
 * @Date 2018/5/27 17:19
 * @Version 1.0
 **/

@Configuration
@ConditionalOnProperty(name = "swagger.switch", havingValue = "true")
@EnableSwagger2
public class Swagger2Config {

    @Autowired
    private SwaggerProperties properties;

    @Bean
    public Docket createRestApi() {

        ApiSelectorBuilder apis = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getBasePackage()));
        if(StringUtils.isEmpty(properties.getPathRegex())){
            return apis.paths(PathSelectors.any()).build().produces(Sets.newHashSet(MediaType.APPLICATION_JSON_UTF8_VALUE));
        }else{
            return apis.paths(Predicates.or(regex(properties.getPathRegex()))).build().produces(Sets.newHashSet(MediaType.APPLICATION_JSON_UTF8_VALUE));
        }
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .version(properties.getVersion())
                .build();
    }

}
