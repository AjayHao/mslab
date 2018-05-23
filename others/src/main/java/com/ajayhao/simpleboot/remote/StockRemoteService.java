package com.ajayhao.simpleboot.remote;

import com.ajayhao.simpleboot.remote.dto.JuHeStockDto;
import com.ajayhao.simpleboot.remote.dto.request.JuHeStockReq;
import com.ajayhao.simpleboot.remote.dto.response.JuHeRemoteResp;

import java.util.List;

/**
 * Created by AjayHao on 2018/5/20.
 */
public interface StockRemoteService {
    JuHeRemoteResp<List<JuHeStockDto>> queryStockInfo(JuHeStockReq stockReq);
}
