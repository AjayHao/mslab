package com.ajayhao.mslab.antxchecker.controller;

import com.ajayhao.mslab.antxchecker.dto.StockInfoReq;
import com.ajayhao.mslab.antxchecker.dto.StockInfoResp;
import com.ajayhao.mslab.antxchecker.service.StockInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
