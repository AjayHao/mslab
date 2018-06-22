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
@RequestMapping(value = "/elastic")
public class CrawlerController {

    @Autowired
    private CrawlerService crawlerService;

    @ApiOperation("elsaic")
    @RequestMapping(value = "/", method = GET)
    public ElecreditResp getEleCreditInfo(@RequestParam("companyId") String companyId,
                                          @RequestParam(value = "category",required = false) String category) {
        return crawlerService.crawlEleCreditInfo(companyId,category);
    }
}
