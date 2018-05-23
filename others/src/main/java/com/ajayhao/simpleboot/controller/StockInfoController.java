package com.ajayhao.simpleboot.controller;

import com.ajayhao.simpleboot.dto.StockInfoReq;
import com.ajayhao.simpleboot.dto.StockInfoResp;
import com.ajayhao.simpleboot.service.StockInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by AjayHao on 2017/6/18.
 */
@Slf4j
@Api("股票信息")
@RestController
@RequestMapping(value = "/stockInfo")
public class StockInfoController {

    @Autowired
    private StockInfoService stockInfoService;

    @ApiOperation("录入股票信息")
    @RequestMapping(value = "/record/{gid}", method = POST)
    public StockInfoResp recordStockInfo(@PathVariable String gid) {
        StockInfoReq req = new StockInfoReq();
        req.setGid(gid);
        return stockInfoService.recordLatestStockInfo(req);
    }
}
