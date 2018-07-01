package com.ajayhao.mslab.crawler.controller;

import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.ajayhao.mslab.crawler.dto.response.ElecreditResp;
import com.ajayhao.mslab.crawler.dto.response.EntEquityInfoResp;
import com.ajayhao.mslab.crawler.dto.response.EntGsInfoResp;
import com.ajayhao.mslab.crawler.enums.GsInfoQryType;
import com.ajayhao.mslab.crawler.service.CrawlerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

    @ApiOperation("企业全称查询")
    @RequestMapping(value = "/queryCompanyFullName", method = GET)
    public ElecreditResp queryCompanyFullName(@RequestParam("keyword") String keyword){
        return crawlerService.pullCompanyFullName(keyword);
    }

    @ApiOperation("企业entId查询")
    @RequestMapping(value = "/queryEntId", method = GET)
    public ElecreditResp getEntId(@RequestParam("keyword") String keyword,
                                  @RequestParam("type") String type) {
        return crawlerService.pullEntId(keyword, type);
    }

    @ApiOperation("企业工商信息查询")
    @RequestMapping(value = "/queryGsBaseInfo", method = GET)
    public EntGsInfoResp queryGsBaseInfo(@RequestParam("keyword") String keyword,
                                         @RequestParam("type") String type) {
        EntGsInfoResp entGsInfoResp = new EntGsInfoResp().buildSuccess();
        //validate
        if(StringUtils.isBlank(keyword)){
            entGsInfoResp.setRespCode(RespCodeType.INVALID_PARAM.getCode());
            entGsInfoResp.setRespMsg(RespCodeType.INVALID_PARAM.getMessage());
            return entGsInfoResp;
        }
        if(StringUtils.isBlank(type)){
            entGsInfoResp.setRespCode(RespCodeType.INVALID_PARAM.getCode());
            entGsInfoResp.setRespMsg(RespCodeType.INVALID_PARAM.getMessage());
            return entGsInfoResp;
        }
        return crawlerService.queryGsBaseInfo(keyword, GsInfoQryType.get(type));
    }

    @ApiOperation("股权结构查询")
    @RequestMapping(value = "/queryEquityInfo", method = GET)
    public EntEquityInfoResp queryEquityInfo(@RequestParam("keyword") String keyword,
                                             @RequestParam("type") String type) {
        EntEquityInfoResp entEquityInfoResp = new EntEquityInfoResp().buildSuccess();
        //validate
        if(StringUtils.isBlank(keyword)){
            entEquityInfoResp.setRespCode(RespCodeType.INVALID_PARAM.getCode());
            entEquityInfoResp.setRespMsg(RespCodeType.INVALID_PARAM.getMessage());
            return entEquityInfoResp;
        }
        if(StringUtils.isBlank(type)){
            entEquityInfoResp.setRespCode(RespCodeType.INVALID_PARAM.getCode());
            entEquityInfoResp.setRespMsg(RespCodeType.INVALID_PARAM.getMessage());
            return entEquityInfoResp;
        }
        return crawlerService.queryEquityInfo(keyword, GsInfoQryType.get(type));
    }

    /*@ApiOperation("企业工商信息查询")
    @RequestMapping(value = "/elsaic", method = GET)
    public EntGsInfoResp getEleCreditInfo(@RequestParam("companyId") String companyId,
                                          @RequestParam("category") String category) {
        return crawlerService.crawlEleCreditInfo(companyId,category);
    }*/

    @ApiOperation("根据工商企业号查询企业全称")
    @RequestMapping(value = "/compname", method = GET)
    public ElecreditResp getCompNameByCreditCode(@RequestParam("keyword") String keyword){
        return crawlerService.crawlCompanyNameByCreditCode(keyword);
    }

    @ApiOperation("舆情查询")
    @RequestMapping(value = "/publicvoice", method = GET)
    public ElecreditResp getPublicVoices(@RequestParam("companyId") String companyId,
                                         @RequestParam(name = "begin",required = false) String begin,
                                         @RequestParam(name = "end",required = false) String end) {
        return crawlerService.crawlPublicVoices(companyId, begin, end);
    }


    @ApiOperation("股权结构查询-remote")
    @RequestMapping(value = "/saicinv", method = GET)
    public ElecreditResp getEntityInvestChain(@RequestParam("companyId") String companyId,
                                         @RequestParam(name = "version",required = false) String version) {
        return crawlerService.crawlEntityInvestChain(companyId, version);
    }


    @ApiOperation("全量同步")
    @RequestMapping(value = "/syncAll", method = GET)
    public ElecreditResp syncAll() {
        return crawlerService.syncAll();
    }
}
