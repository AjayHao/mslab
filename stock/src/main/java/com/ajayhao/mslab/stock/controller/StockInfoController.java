package com.ajayhao.mslab.stock.controller;

import com.ajayhao.mslab.core.common.BaseResp;
import com.ajayhao.mslab.stock.dto.StockInfoReq;
import com.ajayhao.mslab.stock.dto.StockInfoResp;
import com.ajayhao.mslab.stock.service.StockInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by AjayHao on 2017/6/18.
 */
@Slf4j
@Api("Stock信息")
@RestController
@RequestMapping(value = "/stockInfo")
//@CrossOrigin(origins = "*",maxAge = 3600)
public class StockInfoController {

    @Autowired
    private StockInfoService stockInfoService;

    @ApiOperation("Stock信息")
    @RequestMapping(value = "/record/{gid}", method = POST)
    public StockInfoResp recordStockInfo(@PathVariable String gid) {
        StockInfoReq req = new StockInfoReq();
        req.setGid(gid);
        return stockInfoService.recordLatestStockInfo(req);
    }

    @RequestMapping(value = "/random", method = GET)
    public BaseResp<String> random() {
        return BaseResp.buildSuccess("Random double value from Stock:" + RandomUtils.nextDouble());
    }

}
