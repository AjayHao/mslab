package com.ajayhao.mslab.stock;

import com.google.common.collect.Sets;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * <P><P>
 * @author haozhenjie
 * @version $Id: Swagger2.java, v 0.1 2018年4月17日 下午3:24:39
 */
@ConditionalOnProperty(name = "swagger.switch", havingValue = "true")
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.ajayhao.mslab.stock")).paths(PathSelectors.any()).build()
                .apiInfo(apiInfo()).produces(Sets.newHashSet(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs").description("Micro Service Lab,/mslab/stock")
                .version("1.0").build();
    }
}
