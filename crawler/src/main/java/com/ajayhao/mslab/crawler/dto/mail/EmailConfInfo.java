package com.ajayhao.mslab.crawler.dto.mail;


import com.ajayhao.mslab.crawler.dto.JsonPrintableDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 邮箱下载配置包装类
 * @date 2019/12/9 11:36
 * @author Tiger Li
 * @version 1.0
 */
@Setter
@Getter
public class EmailConfInfo extends JsonPrintableDTO {

    private String emailId;

    private String host;

    private Short port;

    private String username;

    private String password;

    private String protocol;

    private String status;

    private String rootPath;

    // private String cron;

    private String mailboxName;

    private String teamCode;

    private String teamName;

    private String mailManager;

    private String mailManagerName;

    private String remark;

    private Date createdAt;

    private String creator;

    private Date updatedAt;

    private String updater;

    private String isDelete;

    private String valid;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastReceiveTime;
}
