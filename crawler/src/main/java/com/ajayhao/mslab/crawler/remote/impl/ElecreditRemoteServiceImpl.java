package com.ajayhao.mslab.crawler.remote.impl;

import com.ajayhao.mslab.core.util.UnicodeUtil;
import com.ajayhao.mslab.crawler.config.ElecreditConfig;
import com.ajayhao.mslab.crawler.helper.ElecreditHelper;
import com.ajayhao.mslab.crawler.remote.ElecreditRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @ClassName ElecreditRemoteServiceImpl
 * @Description 元数企业信息实现类
 * @Author Ajay Hao
 * @Date 2018/6/21 15:14
 * @Version 1.0
 **/
@Service("elecreditRemoteService")
public class ElecreditRemoteServiceImpl implements ElecreditRemoteService{

    @Autowired
    private ElecreditHelper elecreditHelper;

    @Autowired
    private ElecreditConfig elecreditConfig;

    /**
     * @Description 获取企业征信信息
     * @Param [entId, category]
     * @return java.lang.String
     **/
    @Override
    public String crawlEleCreditInfo(String entId, String category) {
        //构造参数
        Map<String,String> paramMap = elecreditHelper.buildElsaicParam(entId, category);

        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = elecreditHelper.buildRequestEntity(paramMap);

        //提交post请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(elecreditConfig.getElsaicUrl(), requestEntity, String.class);
        String respEntityBody = responseEntity.getBody();
        return UnicodeUtil.unicodeToString(respEntityBody);
    }

    /**
     * @Description 获取企业id
     * @Param keyWord 查询关键字， type 类型 1-信用代码/注册号 3-企业名称全称
     * @return java.lang.String
     **/
    @Override
    public String crawlEntId(String keyWord, String type) {
        //构造参数
        Map<String,String> paramMap = elecreditHelper.buildGetEntIdParam(keyWord, type);

        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = elecreditHelper.buildRequestEntity(paramMap);

        //提交post请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(elecreditConfig.getGetEntIdUrl(), requestEntity, String.class);
        String respEntityBody = responseEntity.getBody();
        return UnicodeUtil.unicodeToString(respEntityBody);
    }

    /**
     * @Description 根据简称取企业全称
     * @Param keyWord 查询关键字
     * @return java.lang.String
     **/
    @Override
    public String crawlCompanyFullName(String keyWord) {
        //构造参数
        Map<String,String> paramMap = elecreditHelper.buildFullNameParam(keyWord);

        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = elecreditHelper.buildRequestEntity(paramMap);

        //提交post请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(elecreditConfig.getMohuUrl(), requestEntity, String.class);
        String respEntityBody = responseEntity.getBody();
        return UnicodeUtil.unicodeToString(respEntityBody);
    }

    /**
     * @Description 根据工商企业号取企业全称
     * @Param key 工商企业号
     * @return java.lang.String
     **/
    @Override
    public String crawlCompanyNameByCreditCode(String key) {
        //构造参数
        Map<String,String> paramMap = elecreditHelper.buildCompnameByCreditCodeParam(key);

        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = elecreditHelper.buildRequestEntity(paramMap);

        //提交post请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(elecreditConfig.getComnameUrl(), requestEntity, String.class);
        String respEntityBody = responseEntity.getBody();
        return UnicodeUtil.unicodeToString(respEntityBody);
    }

    /**
     * @Description 查询企业新闻
     * @Param companyId entId
     * @return java.lang.String
     **/
    @Override
    public String crawlCompanyNews(String companyId, String category, String begin, String end) {
        //构造参数
        Map<String,String> paramMap = elecreditHelper.buildCompanyNewsParam(companyId, category, begin, end);

        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = elecreditHelper.buildRequestEntity(paramMap);

        //提交post请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(elecreditConfig.getNewsUrl(), requestEntity, String.class);
        String respEntityBody = responseEntity.getBody();
        return UnicodeUtil.unicodeToString(respEntityBody);
    }

}
