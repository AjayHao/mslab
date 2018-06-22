package com.ajayhao.mslab.crawler.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ElecreditConfig
 * @Description 元素征信配置
 * @Author Ajay Hao
 * @Date 2018/6/22 9:00
 * @Version 1.0
 **/

@Component
@ConfigurationProperties(prefix = "elecredit.cfg")
@Data
public class ElecreditConfig {
    /*
    * 元素账户id
    **/
    private String userId;
    /*
    * 元素账户key，加密用
    **/
    private String userKey;
    /*
    * 访问url
    **/
    private String elsaicUrl;


}
