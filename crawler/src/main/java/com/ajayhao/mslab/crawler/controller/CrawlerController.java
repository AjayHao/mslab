package com.ajayhao.mslab.crawler.controller;

import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.ajayhao.mslab.crawler.dto.response.EntCommonResp;
import com.ajayhao.mslab.crawler.dto.response.EntEquityInfoResp;
import com.ajayhao.mslab.crawler.dto.response.EntGsInfoResp;
import com.ajayhao.mslab.crawler.enums.EntParamType;
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
    public EntCommonResp queryCompanyFullName(@RequestParam("keyword") String keyword){
        return crawlerService.pullCompanyFullName(keyword);
    }

    @ApiOperation("企业entId查询")
    @RequestMapping(value = "/queryEntId", method = GET)
    public EntCommonResp getEntId(@RequestParam("keyword") String keyword,
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
        return crawlerService.queryGsBaseInfo(EntParamType.get(type), keyword);
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
        return crawlerService.queryEquityInfo(EntParamType.get(type), keyword);
    }

    @ApiOperation("企业工商信息查询 - Remote")
    @RequestMapping(value = "/elsaic", method = GET)
    public EntGsInfoResp getEleCreditInfo(@RequestParam("companyId") String companyId,
                                          @RequestParam("category") String category) {
        return crawlerService.crawlEleCreditInfo(companyId,category);
    }

    @ApiOperation("根据工商企业号查询企业全称 - Remote")
    @RequestMapping(value = "/compname", method = GET)
    public EntCommonResp getCompNameByCreditCode(@RequestParam("keyword") String keyword){
        return crawlerService.crawlCompanyNameByCreditCode(keyword);
    }

    @ApiOperation("舆情查询 - Remote")
    @RequestMapping(value = "/publicvoice", method = GET)
    public EntCommonResp getPublicVoices(@RequestParam("companyId") String companyId,
                                         @RequestParam(name = "begin",required = false) String begin,
                                         @RequestParam(name = "end",required = false) String end) {
        return crawlerService.crawlPublicVoices(companyId, begin, end);
    }


    @ApiOperation("股权结构查询 - Remote")
    @RequestMapping(value = "/saicinv", method = GET)
    public EntCommonResp getRemoteEquityInfo(@RequestParam("companyId") String companyId,
                                             @RequestParam(name = "version",required = false) String version) {
        return crawlerService.crawlEntEquityControl(companyId, version);
    }


    /*@ApiOperation("全量同步 - 临时接口")
    @RequestMapping(value = "/syncAll", method = GET)
    public EntCommonResp syncAll() {
        return crawlerService.syncAll();
    }

    @ApiOperation("指定列表补数据 - 临时接口")
    @RequestMapping(value = "/leakDataByList", method = GET)
    public EntCommonResp leakDataByList() {
        EntCommonResp entEquityInfoResp = new EntCommonResp().buildSuccess();
        String[] list = null;//{"资邦元达（上海）互联网金融信息服务有限公司","深圳五星财富互联网金融服务有限公司","惠州市富轩投资管理有限公司","上海成雨投资控股集团有限公司","安信国恒（北京）互联网信息有限公司","上海融腾金融信息服务有限公司","深圳前海大福资本管理有限公司","杭州怀瑜信息科技有限公司","杭州民华金融信息服务有限公司","上海晟垣金融信息服务有限公司","深圳中银华融金融控股有限公司","上海联璧电子科技有限公司","杭州荣旭信息科技有限公司","永康市稳展汽车信息咨询有限公司","广西桂一族投资咨询有限公司","上海驹秀网络科技有限公司","上海龙响网络科技有限公司","宁波汇博金融服务外包有限公司","广州达为尊投资管理有限公司","上海翥鑫投资管理有限公司","佛山市安稳投资管理咨询有限公司","宜辀金融服务（深圳）有限公司","上海普艺邮风投资管理有限公司","北京弘盛鼎世网络科技有限公司","萨飞投资管理（上海）有限公司","宁波煜庭互联网信息科技有限公司","杭州昊隆互联网科技有限公司","张掖安邦伟业商务咨询有限责任公司","山东青联投资有限公司","津魁互联网金融信息服务（攸县）有限公司","福建云朗网络科技有限公司","浙江昕昕资产管理有限公司","杭州艾慕杰信息技术有限公司","宁波鼎亨汇通企业管理咨询有限公司","北京世通嘉华众筹投资管理有限公司","深圳小马资本管理有限公司","深圳市稳通金融服务有限公司","上海金庞金融信息服务有限公司","上海桢曦金融信息服务有限公司","北京花果信息技术有限公司"};
        for(String keyword : list){
            try {
                EntCommonResp fullNameResp = crawlerService.pullCompanyFullName(keyword);
                crawlerService.queryEquityInfo(EntParamType.BY_NAME, fullNameResp.getResult());
            }catch(Exception e){

            }
        }
        return entEquityInfoResp;
    }
    */
}
