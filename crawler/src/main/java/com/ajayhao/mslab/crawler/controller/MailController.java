package com.ajayhao.mslab.crawler.controller;

import com.ajayhao.mslab.core.common.Result;
import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.ajayhao.mslab.core.util.DateUtil;
import com.ajayhao.mslab.crawler.service.MailService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName MailController
 * @Description 邮件
 * @Author Ajay Hao
 * @Date 2021/1/11 9:42
 * @Version 1.0
 **/
@Slf4j
@Api("邮件下载接口")
@RestController
@RequestMapping(value = "/")
public class MailController {

    @Autowired
    private MailService mailService;

    /***
     * 邮件下载 最近一天，匹配subject
     */
    @GetMapping("/download_mail")
    public Result downloadMail(@RequestParam(name = "mailAddr") String mailAddr,
                               @RequestParam(name = "subject", required = false) String subject) {
        log.info("#BEGIN# MailDataApiController.downloadNewMail, mailAddr={}, subject={}", mailAddr, subject);
        Result result = Result.genSuccessResult(null);
        try {
            Date end = new Date();
            Date begin = DateUtil.addMinutes(end, -60*24);
            mailService.downloadMail(mailAddr, begin, end, subject);
        } catch (Exception e) {
            log.error("邮件下载异常", e);
            result = Result.genFailResult(RespCodeType.SYSTEM_ERROR, e.getMessage());
        }
        return result;
    }
}
