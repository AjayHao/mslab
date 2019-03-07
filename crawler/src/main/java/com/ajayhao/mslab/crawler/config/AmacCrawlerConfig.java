package com.ajayhao.mslab.crawler.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * AmacCrawlerConfig
 * 元素征信配置
 * @author Ajay Hao
 * @date 2018/6/22 9:00
 * @version 1.0
 **/

@Component
@ConfigurationProperties(prefix = "amac.cfg")
@Data
public class AmacCrawlerConfig {
    /**
    * 基础信息url前缀
    */
    private Integer pageNo;
    /**
    * 元素账户key，加密用
    */
    private Integer size;
    /**
     * 超时时间
     */
    private Integer timeout;

    /**
     * 是否自动刷新
     */
    private Boolean autoRefresh;

    /**
     * 有效天数
     */
    private Integer expireDays;

}
