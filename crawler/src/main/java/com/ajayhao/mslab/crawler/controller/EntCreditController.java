package com.ajayhao.mslab.crawler.controller;

import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.ajayhao.mslab.crawler.dto.response.EntEquityDetailResp;
import com.ajayhao.mslab.crawler.dto.response.EntEquityFullResp;
import com.ajayhao.mslab.crawler.dto.response.EntGsInfoResp;
import com.ajayhao.mslab.crawler.enums.EntParamType;
import com.ajayhao.mslab.crawler.service.EntCreditService;
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
 * @ClassName EntCreditController
 * @Description 工商信息接口
 * @Author Ajay Hao
 * @Date 2018/7/10 17:42
 * @Version 1.0
 **/
@Slf4j
@Api("企业工商信息接口")
@RestController
@RequestMapping(value = "/entcredit")
public class EntCreditController {

    @Autowired
    private EntCreditService entCreditService;


    @ApiOperation("企业工商基本信息查询")
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
        return entCreditService.queryGsBaseInfo(EntParamType.get(type), keyword);
    }

    @ApiOperation("企业股权结构查询")
    @RequestMapping(value = "/queryEquityInfo", method = GET)
    public EntEquityFullResp queryEquityInfo(@RequestParam("keyword") String keyword,
                                             @RequestParam("type") String type) {
        EntEquityFullResp entEquityFullResp = new EntEquityFullResp().buildSuccess();
        //validate
        if(StringUtils.isBlank(keyword)){
            entEquityFullResp.setRespCode(RespCodeType.INVALID_PARAM.getCode());
            entEquityFullResp.setRespMsg(RespCodeType.INVALID_PARAM.getMessage());
            return entEquityFullResp;
        }
        if(StringUtils.isBlank(type)){
            entEquityFullResp.setRespCode(RespCodeType.INVALID_PARAM.getCode());
            entEquityFullResp.setRespMsg(RespCodeType.INVALID_PARAM.getMessage());
            return entEquityFullResp;
        }
        return entCreditService.queryEquityInfo(EntParamType.get(type), keyword);
    }

    @ApiOperation("股权穿透查询")
    @RequestMapping(value = "/queryEquityByParentNode", method = GET)
    public EntEquityDetailResp queryEquityByParentNode(@RequestParam("entId") String entId,
                                                       @RequestParam(value = "parentNodeId",required = false) String parentNodeId) {
        EntEquityDetailResp entEquityDetailResp = new EntEquityDetailResp().buildSuccess();
        //validate
        if(StringUtils.isBlank(entId)){
            entEquityDetailResp.setRespCode(RespCodeType.INVALID_PARAM.getCode());
            entEquityDetailResp.setRespMsg(RespCodeType.INVALID_PARAM.getMessage());
            return entEquityDetailResp;
        }

        return entCreditService.queryEquityDetailByParent(entId, parentNodeId);
    }

    /*@ApiOperation("全量同步 - 临时接口")
    @RequestMapping(value = "/syncAll", method = GET)
    public EntCommonResp syncAll() {
        return entCreditService.syncAll();
    }

    @ApiOperation("指定列表补数据 - 临时接口")
    @RequestMapping(value = "/leakDataByList", method = GET)
    public EntCommonResp leakDataByList() {
        EntCommonResp entEquityInfoResp = new EntCommonResp().buildSuccess();
        String[] list = null;//{"资邦元达（上海）互联网金融信息服务有限公司","深圳五星财富互联网金融服务有限公司","惠州市富轩投资管理有限公司","上海成雨投资控股集团有限公司","安信国恒（北京）互联网信息有限公司","上海融腾金融信息服务有限公司","深圳前海大福资本管理有限公司","杭州怀瑜信息科技有限公司","杭州民华金融信息服务有限公司","上海晟垣金融信息服务有限公司","深圳中银华融金融控股有限公司","上海联璧电子科技有限公司","杭州荣旭信息科技有限公司","永康市稳展汽车信息咨询有限公司","广西桂一族投资咨询有限公司","上海驹秀网络科技有限公司","上海龙响网络科技有限公司","宁波汇博金融服务外包有限公司","广州达为尊投资管理有限公司","上海翥鑫投资管理有限公司","佛山市安稳投资管理咨询有限公司","宜辀金融服务（深圳）有限公司","上海普艺邮风投资管理有限公司","北京弘盛鼎世网络科技有限公司","萨飞投资管理（上海）有限公司","宁波煜庭互联网信息科技有限公司","杭州昊隆互联网科技有限公司","张掖安邦伟业商务咨询有限责任公司","山东青联投资有限公司","津魁互联网金融信息服务（攸县）有限公司","福建云朗网络科技有限公司","浙江昕昕资产管理有限公司","杭州艾慕杰信息技术有限公司","宁波鼎亨汇通企业管理咨询有限公司","北京世通嘉华众筹投资管理有限公司","深圳小马资本管理有限公司","深圳市稳通金融服务有限公司","上海金庞金融信息服务有限公司","上海桢曦金融信息服务有限公司","北京花果信息技术有限公司"};
        for(String keyword : list){
            try {
                EntCommonResp fullNameResp = entCreditService.pullCompanyFullName(keyword);
                entCreditService.queryEquityInfo(EntParamType.BY_NAME, fullNameResp.getResult());
            }catch(Exception e){

            }
        }
        return entEquityInfoResp;
    }
    */
}
