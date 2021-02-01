package com.ajayhao.mslab.swagger.support.annotation;

import com.ajayhao.mslab.swagger.support.Swagger3Config;
import com.ajayhao.mslab.swagger.support.SwaggerProperties;
import org.springframework.context.annotation.Import;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({Swagger3Config.class,SwaggerProperties.class})
@EnableOpenApi
public @interface EnableSwaggerConfig {
}
