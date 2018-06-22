package com.ajayhao.mslab.crawler.remote.impl;

import com.ajayhao.mslab.core.util.HMACUtil;
import com.ajayhao.mslab.core.util.UnicodeUtil;
import com.ajayhao.mslab.crawler.config.ElecreditConfig;
import com.ajayhao.mslab.crawler.remote.ElecreditRemoteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName ElecreditRemoteServiceImpl
 * @Description 元数企业信息实现类
 * @Author Ajay Hao
 * @Date 2018/6/21 15:14
 * @Version 1.0
 **/
@Service("elecreditRemoteService")
public class ElecreditRemoteServiceImpl implements ElecreditRemoteService{

    private String charset = "UTF-8";

    @Autowired
    private ElecreditConfig elecreditConfig;

    @Override
    public String crawlEleCreditInfo(String entId, String category) {
        //构造参数
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("entid",entId);
        if(StringUtils.isNotBlank(category)) {
            paramMap.put("version", category);
        }

        //加签加密
        String authStr = getSignRawStr(elecreditConfig.getUserKey(), paramMap);
        HttpHeaders requestHeaders = buildRequestHeader(authStr);
        MultiValueMap<String, String> requestBody = buildRequestBody(paramMap);
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(requestBody, requestHeaders);

        //post取数
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(elecreditConfig.getElsaicUrl(), requestEntity, String.class);
        String respEntityBody = responseEntity.getBody();
        return UnicodeUtil.unicodeToString(respEntityBody);
    }

    private MultiValueMap<String,String> buildRequestBody(Map<String, String> paramMap) {
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
        for(String key : paramMap.keySet()){
            body.add(key, paramMap.get(key));
        }
        return body;
    }

    private HttpHeaders buildRequestHeader(String auth) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        requestHeaders.add("authorization", auth);
        requestHeaders.add("charset", charset);
        return requestHeaders;
    }

    private String getSignRawStr(String userKey, final Map<String,String> params){
        Map<String,String> sortedParams = new TreeMap<>(params);
        StringBuffer sb = new StringBuffer();
        for(String key : sortedParams.keySet()){
            sb = sb.append(key).append(sortedParams.get(key));
        }
        String signRawStr = sb.append(params.get("userid")).toString();
        String authStr = null;
        try {
            authStr = HMACUtil.encode(userKey, signRawStr);
        }catch(Exception e){
            e.printStackTrace();
        }
        return authStr;
    }
}
