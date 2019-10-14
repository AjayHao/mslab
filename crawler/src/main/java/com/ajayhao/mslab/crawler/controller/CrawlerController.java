package com.ajayhao.mslab.crawler.controller;

import com.ajayhao.mslab.core.common.BaseResp;
import com.ajayhao.mslab.crawler.service.EntCreditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @ClassName CrawlerController
 * @Description 元数聚开放平台
 * @Author Ajay Hao
 * @Date 2018/6/6 17:42
 * @Version 1.0
 **/
@Slf4j
@Api("数据爬取接口")
@RestController
@RequestMapping(value = "/crawler")
public class CrawlerController {

    @Autowired
    private EntCreditService crawlerService;


    @ApiOperation("企业工商信息查询 - Remote")
    @RequestMapping(value = "/elsaic", method = GET)
    public BaseResp<String> getEleCreditInfoRaw(@RequestParam("companyId") String companyId,
                                                @RequestParam("category") String category) {
        return crawlerService.crawlEleCreditInfoRaw(companyId,category);
    }

    @ApiOperation("根据简称查询企业全称 - Remote")
    @RequestMapping(value = "/fullcompname", method = GET)
    public BaseResp<String> getFullCompName(@RequestParam("keyword") String keyword){
        return crawlerService.pullCompanyFullName(keyword);
    }

    @ApiOperation("根据企业全称取entId - Remote")
    @RequestMapping(value = "/getentid", method = GET)
    public BaseResp<String> getEntId(@RequestParam("keyword") String keyword){
        return crawlerService.pullEntId(keyword, "3");
    }

    @ApiOperation("根据工商企业号查询企业全称 - Remote")
    @RequestMapping(value = "/compname", method = GET)
    public BaseResp<String> getCompNameByCreditCode(@RequestParam("keyword") String keyword){
        return crawlerService.crawlCompanyNameByCreditCode(keyword);
    }

    @ApiOperation("舆情查询 - Remote")
    @RequestMapping(value = "/publicvoice", method = GET)
    public BaseResp<String> getPublicVoices(@RequestParam("companyId") String companyId,
                                         @RequestParam(name = "begin",required = false) String begin,
                                         @RequestParam(name = "end",required = false) String end) {
        return crawlerService.crawlPublicVoices(companyId, begin, end);
    }


    @ApiOperation("股权结构查询 - Remote")
    @RequestMapping(value = "/saicinv", method = GET)
    public BaseResp<String> getRemoteEquityInfo(@RequestParam("companyId") String companyId,
                                             @RequestParam(name = "version",required = false) String version) {
        return crawlerService.crawlEntEquityControl(companyId, version);
    }

}
