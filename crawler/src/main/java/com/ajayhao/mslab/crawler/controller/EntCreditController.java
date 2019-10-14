package com.ajayhao.mslab.crawler.controller;

import com.ajayhao.mslab.core.common.BaseResp;
import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.ajayhao.mslab.crawler.dto.EntEquityDetailInfo;
import com.ajayhao.mslab.crawler.dto.EntEquityInfo;
import com.ajayhao.mslab.crawler.dto.EntGsInfo;
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

import java.util.List;

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
    public BaseResp<EntGsInfo> queryGsBaseInfo(@RequestParam("keyword") String keyword,
                                               @RequestParam("type") String type) {
        BaseResp entGsInfoResp = BaseResp.buildSuccess();
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
    public BaseResp<EntEquityInfo> queryEquityInfo(@RequestParam("keyword") String keyword,
                                                   @RequestParam("type") String type) {
        BaseResp<EntEquityInfo> entEquityFullResp = BaseResp.buildSuccess();
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
    public BaseResp<List<EntEquityDetailInfo>> queryEquityByParentNode(@RequestParam("entId") String entId,
                                                                       @RequestParam(value = "parentNodeId",required = false) String parentNodeId) {
        BaseResp<List<EntEquityDetailInfo>> entEquityDetailResp = BaseResp.buildSuccess();
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
    }*/

    @ApiOperation("指定列表补数据 - 临时接口")
    @RequestMapping(value = "/leakDataByList", method = GET)
    public BaseResp<String> leakDataByList() {
        BaseResp<String> dataResp = BaseResp.buildSuccess();
        String[] list = {"杭州金雕资产管理有限公司","深圳市兆富资本管理有限公司","深圳前海佰盛资产管理有限公司","华宇浩海（宁波）投资管理有限公司","华夏恒天资本管理有限公司","华宇华高资产管理有限公司","上海常圣资产管理有限公司","北京中兴天元投资管理有限公司","华融优创投资基金管理有限公司","上海众盈财富投资管理有限公司","深圳荧兴源资产管理集团有限公司","华宇国信投资基金（北京）有限公司","汇德华融（平潭）资产管理有限公司","上海云枫股权投资基金管理有限公司","信达海胜（深圳）基金管理有限公司","北京未来能源投资基金管理股份有限公司","国投信达（北京）投资基金集团有限公司","中隆华夏（北京）投资基金管理有限公司","中新鸿泰（北京）投资基金管理有限公司","中洲博远（北京）投资管理咨询有限公司","中贵首控（成都）股权投资基金管理有限公司"};
        for(String keyword : list){
            try {
                BaseResp<String> fullNameResp = entCreditService.pullCompanyFullName(keyword);
                entCreditService.queryGsBaseInfo(EntParamType.BY_NAME, fullNameResp.getData());
                entCreditService.queryEquityInfo(EntParamType.BY_NAME, fullNameResp.getData());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return dataResp;
    }

}
