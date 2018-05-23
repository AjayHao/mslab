package com.ajayhao.simpleboot.service;

import com.ajayhao.simpleboot.dto.StockInfoReq;
import com.ajayhao.simpleboot.dto.StockInfoResp;

/**
 * Created by AjayHao on 2018/5/21.
 */
public interface StockInfoService {
    StockInfoResp recordLatestStockInfo(StockInfoReq req);
}
