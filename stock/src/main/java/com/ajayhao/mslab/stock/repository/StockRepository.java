package com.ajayhao.mslab.stock.repository;

import com.ajayhao.mslab.stock.orm.entity.StockInfoDO;

/**
 * Created by AjayHao on 2018/5/20.
 */
public interface StockRepository {

    StockInfoDO getStockInfoByGidDate(String gid, String workDate);

    long newStockInfo(StockInfoDO stockInfoDO);
}
