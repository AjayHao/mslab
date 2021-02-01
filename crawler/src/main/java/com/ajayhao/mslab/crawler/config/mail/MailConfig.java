package com.ajayhao.mslab.crawler.config.mail;

import com.ajayhao.mslab.crawler.dto.mail.EmailConfInfo;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * MailConfig
 * <p>
 * 邮件启动配置
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2021/1/11 15:03
 */
@Configuration
@ConfigurationProperties("mail-server")
@Setter
public class MailConfig {


    private List<EmailConfInfo> cfgList;

    @Bean("mailConfigMap")
    public Map<String, EmailConfInfo> mailConfigMap() {
        Map<String, EmailConfInfo> cfgInfo = new HashMap<>();
        if (CollectionUtils.isNotEmpty(cfgList)) {
            cfgInfo = cfgList.stream().collect(Collectors.toMap(EmailConfInfo::getUsername, item -> item));
        }
        return cfgInfo;
    }
}
