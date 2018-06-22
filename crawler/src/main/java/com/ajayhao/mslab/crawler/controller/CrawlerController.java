package com.ajayhao.mslab.crawler.controller;

import com.ajayhao.mslab.crawler.dto.ElecreditResp;
import com.ajayhao.mslab.crawler.service.CrawlerService;
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
@Api("元数征信平台接口")
@RestController
@RequestMapping(value = "/elecredit")
public class CrawlerController {

    @Autowired
    private CrawlerService crawlerService;

    @ApiOperation("企业工商信息查询")
    @RequestMapping(value = "/elsaic", method = GET)
    public ElecreditResp getEleCreditInfo(@RequestParam("companyId") String companyId,
                                          @RequestParam("category") String category) {
        return crawlerService.crawlEleCreditInfo(companyId,category);
    }

    @ApiOperation("企业entId查询")
    @RequestMapping(value = "/getentid", method = GET)
    public ElecreditResp getEntId(@RequestParam("keyword") String keyword,
                                   @RequestParam("type") String type) {
        return crawlerService.crawlEntId(keyword, type);
    }

    @ApiOperation("企业全称查询")
    @RequestMapping(value = "/mohu", method = GET)
    public ElecreditResp getCompanyFullName(@RequestParam("keyword") String keyword){
        return crawlerService.crawlCompanyFullName(keyword);
    }

    @ApiOperation("根据工商企业号查询企业全称")
    @RequestMapping(value = "/compname", method = GET)
    public ElecreditResp getCompNameByCreditCode(@RequestParam("keyword") String keyword){
        return crawlerService.crawlCompanyNameByCreditCode(keyword);
    }

    @ApiOperation("新闻查询")
    @RequestMapping(value = "/news", method = GET)
    public ElecreditResp getCompanyNews(@RequestParam("companyId") String companyId,
                                                 @RequestParam(name = "category",required = false) String category,
                                                 @RequestParam(name = "begin",required = false) String begin,
                                                 @RequestParam(name = "end",required = false) String end) {
        return crawlerService.crawlCompanyNews(companyId, category, begin, end);
    }

}
