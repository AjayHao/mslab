package com.ajayhao.mslab.stock.remote.impl;

import com.ajayhao.mslab.core.util.JsonUtil;
import com.ajayhao.mslab.stock.config.RemoteConfig;
import com.ajayhao.mslab.stock.remote.StockRemoteService;
import com.ajayhao.mslab.stock.remote.dto.JuHeStockDto;
import com.ajayhao.mslab.stock.remote.dto.request.JuHeStockReq;
import com.ajayhao.mslab.stock.remote.dto.response.JuHeRemoteResp;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by AjayHao on 2018/5/20.
 */
@Service("stockRemoteService")
public class StockRemoteServiceImpl implements StockRemoteService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RemoteConfig remoteConfig;

    @Override
    public JuHeRemoteResp<List<JuHeStockDto>> queryStockInfo(JuHeStockReq stockReq){
        String remoteRespStr = restTemplate.getForObject(remoteConfig.getJuheServiceUrl(), String.class, stockReq.getGid(), stockReq.getKey());
        JuHeRemoteResp<List<JuHeStockDto>> remoteResp = JsonUtil.parse(remoteRespStr, new TypeReference<JuHeRemoteResp<List<JuHeStockDto>>>() {});
        return remoteResp;
    }
}
