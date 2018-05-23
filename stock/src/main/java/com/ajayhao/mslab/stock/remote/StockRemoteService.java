package com.ajayhao.mslab.stock.remote;

import com.ajayhao.mslab.stock.remote.dto.request.JuHeStockReq;
import com.ajayhao.mslab.stock.remote.dto.response.JuHeRemoteResp;
import com.ajayhao.mslab.stock.remote.dto.JuHeStockDto;

import java.util.List;

/**
 * Created by AjayHao on 2018/5/20.
 */
public interface StockRemoteService {
    JuHeRemoteResp<List<JuHeStockDto>> queryStockInfo(JuHeStockReq stockReq);
}
