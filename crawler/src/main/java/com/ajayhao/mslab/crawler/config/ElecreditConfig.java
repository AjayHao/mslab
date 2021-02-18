package com.ajayhao.mslab.crawler.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName ElecreditConfig
 * @Description 元素征信配置
 * @Author Ajay Hao
 * @Date 2018/6/22 9:00
 * @Version 1.0
 **/

@Configuration
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
    * url - 查询企业工商信息
    **/
    private String elsaicUrl;
    /*
    * url - 查企业名称-模糊查询url
    **/
    private String mohuUrl;
    /*
    * url - 查企业名称url
    **/
    private String comnameUrl;
    /*
    * url - 查企业舆情url
    **/
    private String newGuoTaiUrl;
    /*
    * url - 获取entid
    **/
    private String getEntIdUrl;
    /*
    * url - 股权结构信息
    **/
    private String saicInvUrl;
}
