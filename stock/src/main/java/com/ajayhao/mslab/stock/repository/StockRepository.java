package com.ajayhao.mslab.stock.repository;

import com.ajayhao.mslab.stock.dal.dataobject.StockInfoDO;

/**
 * Created by AjayHao on 2018/5/20.
 */
public interface StockRepository {

    StockInfoDO getStockInfoByGidDate(String gid, String workDate);

    long newStockInfo(StockInfoDO stockInfoDO);
}
