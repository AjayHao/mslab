package com.ajayhao.mslab.crawler.remote.impl;

import com.ajayhao.mslab.core.common.exception.BusinessBizException;
import com.ajayhao.mslab.core.util.UnicodeUtil;
import com.ajayhao.mslab.crawler.config.ElecreditConfig;
import com.ajayhao.mslab.crawler.dto.EntEquityInfo;
import com.ajayhao.mslab.crawler.dto.EntGsInfo;
import com.ajayhao.mslab.crawler.helper.ElecreditHelper;
import com.ajayhao.mslab.crawler.remote.ElecreditRemoteService;
import com.ajayhao.mslab.crawler.remote.dto.EntNameRemoteResp;
import com.ajayhao.mslab.crawler.remote.dto.SaicInvRemoteResp;
import com.ajayhao.mslab.crawler.remote.dto.response.RemoteGetEntIdResp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static com.ajayhao.mslab.core.common.enums.RespCodeType.*;
import static com.ajayhao.mslab.crawler.constant.CrawlerConstants.REMOTE_SUCC;

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
    public EntGsInfo pullEleCreditInfo(String entId, String category) {
        //构造参数
        Map<String,String> paramMap = elecreditHelper.buildElsaicParam(entId, category);

        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = elecreditHelper.buildRequestEntity(paramMap);

        //提交post请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(elecreditConfig.getElsaicUrl(), requestEntity, String.class);
        String respEntityBody = responseEntity.getBody();
        String jsonStr = UnicodeUtil.unicodeToString(respEntityBody);
        EntGsInfo entGsInfo = null;
        JSONObject json = JSON.parseObject(jsonStr);

        if(json == null || json.get("meta") == null || !REMOTE_SUCC.equals(((JSONObject)json.get("meta")).get("code"))){
            throw new BusinessBizException(REMOTE_INVOKE_ERROR);
        }else{
            entGsInfo = elecreditHelper.resolveElsaicResp(json);
            entGsInfo.setEntId(entId);
        }
        return entGsInfo;
    }

    /**
     * @Description 获取股权信息
     * @Param entId
     * @return EntEquityInfo
     **/
    @Override
    public EntEquityInfo pullEquityInfo(String entId) {
        //构造参数
        Map<String,String> paramMap = elecreditHelper.buildEquityInfoParam(entId, "1"); //信息不脱敏

        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = elecreditHelper.buildRequestEntity(paramMap);

        //提交post请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SaicInvRemoteResp> responseEntity = restTemplate.postForEntity(elecreditConfig.getSaicInvUrl(), requestEntity, SaicInvRemoteResp.class);
        SaicInvRemoteResp saicInvRemoteResp = responseEntity.getBody();
        EntEquityInfo entEquityInfo = null;

        if(saicInvRemoteResp == null || !REMOTE_SUCC.equals(saicInvRemoteResp.getCode())){
            throw new BusinessBizException(REMOTE_INVOKE_ERROR);
        }else{
            entEquityInfo = elecreditHelper.resolveEquityInfoResp(saicInvRemoteResp, entId);
        }
        return entEquityInfo;
    }

    /**
     * @Description 获取企业id
     * @Param keyWord 查询关键字， type 类型 1-信用代码/注册号 3-企业名称全称
     * @return java.lang.String
     **/
    @Override
    public String pullEntId(String keyWord, String type) {
        //构造参数
        Map<String,String> paramMap = elecreditHelper.buildGetEntIdParam(keyWord, type);

        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = elecreditHelper.buildRequestEntity(paramMap);

        //提交post请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RemoteGetEntIdResp> responseEntity = restTemplate.postForEntity(elecreditConfig.getGetEntIdUrl(), requestEntity, RemoteGetEntIdResp.class);
        RemoteGetEntIdResp remoteResp = responseEntity.getBody();
        if(!REMOTE_SUCC.equals(remoteResp.getCode())){
            throw new BusinessBizException(REMOTE_INVOKE_ERROR);
        }
        return remoteResp.getData();
    }

    /**
     * @Description 根据简称取企业全称
     * @Param keyWord 查询关键字
     * @return java.lang.String
     **/
    @Override
    public String pullCompanyFullName(String keyWord) {
        //构造参数
        Map<String,String> paramMap = elecreditHelper.buildFullNameParam(keyWord);

        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = elecreditHelper.buildRequestEntity(paramMap);

        //提交post请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EntNameRemoteResp> responseEntity = restTemplate.postForEntity(elecreditConfig.getMohuUrl(), requestEntity, EntNameRemoteResp.class);
        EntNameRemoteResp remoteResp = responseEntity.getBody();
        if(remoteResp == null || !REMOTE_SUCC.equals(remoteResp.getCode())){
            throw new BusinessBizException(REMOTE_INVOKE_ERROR);
        }else if(remoteResp.getData() == null || remoteResp.getData().size() == 0
                    || StringUtils.isBlank(remoteResp.getData().get(0).getEntName())){
            throw new BusinessBizException(FULL_NAME_NOT_FOUND);
        }else if(remoteResp.getData() == null || remoteResp.getData().size() > 1){
            throw new BusinessBizException(TOO_MANY_FULL_NAMES, StringUtils.join(remoteResp.getData()));
        }

        return remoteResp.getData().get(0).getEntName();
    }

    /**
     * @Description 根据工商企业号取企业全称
     * @Param key 工商企业号
     * @return java.lang.String
     **/
    @Override
    public String pullCompanyNameByCreditCode(String key) {
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
     * @Description 查询股权投资链
     * @Param companyId entId
     * @return java.lang.String
     **/
    @Override
    public String pullEntEquityControl(String companyId, String version) {
        //构造参数
        Map<String,String> paramMap = elecreditHelper.buildEquityInfoParam(companyId, version);

        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = elecreditHelper.buildRequestEntity(paramMap);

        //提交post请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(elecreditConfig.getSaicInvUrl(), requestEntity, String.class);
        String respEntityBody = responseEntity.getBody();
        return UnicodeUtil.unicodeToString(respEntityBody);
    }

    /**
     * @Description 查询企业舆情
     * @Param companyId entId
     * @return java.lang.String
     **/
    @Override
    public String pullPublicVoices(String companyId, String begin, String end) {
        //构造参数
        Map<String,String> paramMap = elecreditHelper.buildPublicVoicesParam(companyId, begin, end);

        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = elecreditHelper.buildRequestEntity(paramMap);

        //提交post请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(elecreditConfig.getNewGuoTaiUrl(), requestEntity, String.class);
        String respEntityBody = responseEntity.getBody();
        return UnicodeUtil.unicodeToString(respEntityBody);
    }

}
