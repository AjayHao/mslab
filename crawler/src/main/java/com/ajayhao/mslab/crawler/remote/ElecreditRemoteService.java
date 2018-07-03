package com.ajayhao.mslab.crawler.remote;

import com.ajayhao.mslab.crawler.dto.EntEquityInfo;
import com.ajayhao.mslab.crawler.dto.EntGsInfo;
import com.ajayhao.mslab.crawler.remote.dto.response.RemoteGetEntIdResp;

import java.util.Map;

/**
 * @InterfaceName ElecreditRemoteService
 * @Description 元数企业信息
 * @Author Ajay Hao
 * @Date 2018/6/21 15:13
 * @Version 1.0
 **/
public interface ElecreditRemoteService {
    /**
    * @Description 爬取企业征信信息
    * @Param [entId, category]
    * @return java.lang.String
    **/
    EntGsInfo pullEleCreditInfo(String entId, String category);

    /**
     * @Description 获取股权信息
     * @Param entId
     * @return EntEquityInfo
     **/
    EntEquityInfo pullEquityInfo(String entId);

    /**
     * @Description 获取企业id
     * @Param keyWord 查询关键字， type 类型 1-信用代码/注册号 3-企业名称全称
     * @return java.lang.String
     **/
    String pullEntId(String keyWord, String type);

    /**
     * @Description 根据简称取企业全称
     * @Param keyWord 查询关键字
     * @return java.lang.String
     **/
    String pullCompanyFullName(String key);

    /**
     * @Description 根据工商企业号取企业全称
     * @Param key 工商企业号
     * @return java.lang.String
     **/
    String pullCompanyNameByCreditCode(String key);

    /**
     * @Description 查询股权投资链
     * @Param companyId entId
     * @return java.lang.String
     **/
    String pullEntEquityControl(String companyId, String version);

    /**
     * @Description 查询企业新闻
     * @Param companyId entId
     * @return java.lang.String
     **/
    String pullPublicVoices(String companyId, String begin, String end);
}
