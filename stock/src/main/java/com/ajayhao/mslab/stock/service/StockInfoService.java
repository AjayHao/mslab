package com.ajayhao.mslab.stock.service;

import com.ajayhao.mslab.stock.dto.StockInfoReq;
import com.ajayhao.mslab.stock.dto.StockInfoResp;

/**
 * Created by AjayHao on 2018/5/21.
 */
public interface StockInfoService {
    StockInfoResp recordLatestStockInfo(StockInfoReq req);
}
