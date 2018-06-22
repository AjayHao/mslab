package com.ajayhao.mslab.crawler.remote;

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
    String crawlEleCreditInfo(String entId, String category);

    /**
     * @Description 获取企业id
     * @Param keyWord 查询关键字， type 类型 1-信用代码/注册号 3-企业名称全称
     * @return java.lang.String
     **/
    String crawlEntId(String keyWord, String type);

    /**
     * @Description 根据简称取企业全称
     * @Param keyWord 查询关键字
     * @return java.lang.String
     **/
    String crawlCompanyFullName(String key);

    /**
     * @Description 根据工商企业号取企业全称
     * @Param key 工商企业号
     * @return java.lang.String
     **/
    String crawlCompanyNameByCreditCode(String key);

    /**
     * @Description 查询企业新闻
     * @Param companyId entId
     * @return java.lang.String
     **/
    String crawlPublicVoices(String companyId, String begin, String end);
}
