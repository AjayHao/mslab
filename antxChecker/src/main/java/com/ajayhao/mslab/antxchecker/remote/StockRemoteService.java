package com.ajayhao.mslab.antxchecker.remote;

import com.ajayhao.mslab.antxchecker.remote.dto.request.JuHeStockReq;
import com.ajayhao.mslab.antxchecker.remote.dto.JuHeStockDto;
import com.ajayhao.mslab.antxchecker.remote.dto.response.JuHeRemoteResp;

import java.util.List;

/**
 * Created by AjayHao on 2018/5/20.
 */
public interface StockRemoteService {
    JuHeRemoteResp<List<JuHeStockDto>> queryStockInfo(JuHeStockReq stockReq);
}
