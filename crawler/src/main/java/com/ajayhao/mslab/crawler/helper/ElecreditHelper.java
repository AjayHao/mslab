package com.ajayhao.mslab.crawler.helper;

import com.ajayhao.mslab.core.util.HMACUtil;
import com.ajayhao.mslab.crawler.config.ElecreditConfig;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

/**
 * @ClassName ElecreditHelper
 * @Description 元素征信辅助类
 * @Author Ajay Hao
 * @Date 2018/6/22 10:48
 * @Version 1.0
 **/
@Component
public class ElecreditHelper {

    private final String charset = "UTF-8";

    @Autowired
    private ElecreditConfig elecreditConfig;

    /**
    * @Description 构造请求entity
    * @Param [paramMap]
    * @return org.springframework.http.HttpEntity<org.springframework.util.MultiValueMap>
    **/
    public HttpEntity<MultiValueMap> buildRequestEntity(Map<String,String> paramMap){
        //加签加密
        String authStr = getSignRawStr(elecreditConfig.getUserKey(), paramMap);
        //构造请求头
        HttpHeaders requestHeaders = buildRequestHeader(authStr);
        //构造请求体
        MultiValueMap<String, String> requestBody = buildRequestBody(paramMap);
        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(requestBody, requestHeaders);
        return requestEntity;
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
    /**
    * @Description 工商信息接口参数
    * @Param entId, category
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    public Map<String,String> buildElsaicParam(String entId, String category){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("entid",entId);
        if(StringUtils.isNotBlank(category)) {
            paramMap.put("version", category);
        }
        return paramMap;
    }

    /**
    * @Description 获取企业id接口参数
    * @Param [keyWord, type]
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    public Map<String,String> buildGetEntIdParam(String keyWord, String type) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("key",keyWord);
        paramMap.put("type", type);
        return paramMap;
    }

    /**
     * @Description 获取企业全称接口参数
     * @Param keyWord
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    public Map<String,String> buildFullNameParam(String keyWord) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("key",keyWord);
        return paramMap;
    }

    /**
     * @Description 根据工商注册号获取企业全称接口参数
     * @Param key
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    public Map<String,String> buildCompnameByCreditCodeParam(String key) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("key",key);
        return paramMap;
    }

    /**
     * @Description 查询企业新闻接口参数
     * @Param key
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    public Map<String,String> buildPublicVoicesParam(String companyId, String begin, String end) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("entid",companyId);
        if(StringUtils.isNotBlank(begin)) {
            paramMap.put("begin", begin);
        }
        if(StringUtils.isNotBlank(end)) {
            paramMap.put("end", end);
        }
        return paramMap;
    }
}
