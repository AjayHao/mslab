package com.ajayhao.mslab.crawler;

import com.ajayhao.mslab.crawler.config.RestTemplateConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by AjayHao on 2018/2/17.
 */
@Configuration
@ImportResource("/spring/spring-persistence.xml")
@Import(RestTemplateConfig.class)
public class CrawlerBootConfig {

}
