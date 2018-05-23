package com.ajayhao.simpleboot.remote.impl;

import com.ajayhao.simpleboot.remote.StockRemoteService;
import com.ajayhao.simpleboot.remote.dto.response.JuHeRemoteResp;
import com.ajayhao.simpleboot.remote.dto.JuHeStockDto;
import com.ajayhao.simpleboot.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ajayhao.simpleboot.remote.dto.request.JuHeStockReq;

import java.util.List;

/**
 * Created by AjayHao on 2018/5/20.
 */
@Service("stockRemoteService")
public class StockRemoteServiceImpl implements StockRemoteService{

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://web.juhe.cn:8080/finance/stock/hs?gid={gid}&key={key}";

    @Override
    public JuHeRemoteResp<List<JuHeStockDto>> queryStockInfo(JuHeStockReq stockReq){
        String remoteRespStr = restTemplate.getForObject(url, String.class, stockReq.getGid(), stockReq.getKey());
        JuHeRemoteResp<List<JuHeStockDto>> remoteResp = JsonUtil.parse(remoteRespStr, new TypeReference<JuHeRemoteResp<List<JuHeStockDto>>>() {});
        return remoteResp;
    }
}
