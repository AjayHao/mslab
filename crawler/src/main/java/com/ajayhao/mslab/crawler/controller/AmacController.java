package com.ajayhao.mslab.crawler.controller;

import com.ajayhao.mslab.core.common.Result;
import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.ajayhao.mslab.crawler.dto.AmacFundInfo;
import com.ajayhao.mslab.crawler.dto.AmacManagerInfo;
import com.ajayhao.mslab.crawler.remote.enums.AmacParamType;
import com.ajayhao.mslab.crawler.service.AmacCrawlerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * AmacServiceController
 * 工商信息接口
 * @author Ajay Hao
 * @date 2018/7/10 17:42
 * @version 1.0
 **/
@Slf4j
@Api("协会信息读取接口")
@RestController
@RequestMapping(value = "/service/amac-info")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class AmacController {

    @Autowired
    private AmacCrawlerService amacCrawlerService;


    @ApiOperation("协会私募管理人信息查询")
    @RequestMapping(value = "/manager", method = GET)

    public Result<AmacManagerInfo> queryManagerInfo(@RequestParam("keyword") String keyword,
                                                    @RequestParam("type") String type) {
        log.info("协会私募管理人信息查询开始, keyword:{}, type:{}", keyword, type);
        Result<AmacManagerInfo> result;
        AmacManagerInfo amacManagerInfo;
        try{
            amacManagerInfo = amacCrawlerService.queryAmacManagerInfo(AmacParamType.get(type), keyword);
            result = Result.genSuccessResult(amacManagerInfo);
        }catch(Exception se){
            result = Result.genFailResult(RespCodeType.SYSTEM_ERROR, se.getMessage());
        }
        //log.info("企业工商基本信息查询结束, result={}", result);
        return result;
    }

    @ApiOperation("协会私募管理人旗下信息查询")
    @RequestMapping(value = "/manager-fund", method = GET)
    public Result<List<AmacFundInfo>> queryManagerFundInfo(@RequestParam("keyword") String keyword,
                                                           @RequestParam("type") String type) {
        log.info("协会私募管理人信息查询开始, keyword:{}, type:{}", keyword, type);
        Result<List<AmacFundInfo>> result;
        List<AmacFundInfo> amacFundInfoList;
        try{
            amacFundInfoList = amacCrawlerService.queryAmacFundInfoByManager(AmacParamType.get(type), keyword);
            result = Result.genSuccessResult(amacFundInfoList);
        }catch(Exception se){
            result = Result.genFailResult(RespCodeType.SYSTEM_ERROR, se.getMessage());
        }
        //log.info("企业工商基本信息查询结束, result={}", result);
        return result;
    }

    @ApiOperation("协会私募基金产品信息查询")
    @RequestMapping(value = "/fund", method = GET)
    public Result<AmacFundInfo> queryFundInfo(@RequestParam("fundName") String fundName) {
        log.info("协会私募基金产品信息查询开始, fundName:{}", fundName);
        Result<AmacFundInfo> result;
        AmacFundInfo fundInfo = null;
        try{
            fundInfo = amacCrawlerService.queryAmacFundInfo(fundName);
            result = Result.genSuccessResult(fundInfo);
        }catch(Exception se){
            result = Result.genFailResult(RespCodeType.SYSTEM_ERROR, se.getMessage());
        }
        //log.info("企业工商基本信息查询结束, result={}", result);
        return result;
    }
}
