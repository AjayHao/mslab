package com.ajayhao.mslab.antxchecker.service;

import com.ajayhao.mslab.antxchecker.dto.StockInfoReq;
import com.ajayhao.mslab.antxchecker.dto.StockInfoResp;

/**
 * Created by AjayHao on 2018/5/21.
 */
public interface StockInfoService {
    StockInfoResp recordLatestStockInfo(StockInfoReq req);
}
