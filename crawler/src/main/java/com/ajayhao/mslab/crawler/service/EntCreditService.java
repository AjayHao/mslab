package com.ajayhao.mslab.crawler.service;

import com.ajayhao.mslab.core.common.BaseResp;
import com.ajayhao.mslab.crawler.dto.EntEquityDetailInfo;
import com.ajayhao.mslab.crawler.dto.EntEquityInfo;
import com.ajayhao.mslab.crawler.dto.EntGsInfo;
import com.ajayhao.mslab.crawler.enums.EntParamType;

import java.util.List;

/**
 * @ClassName EntCreditService
 * @Description 爬虫服务
 * @Author Ajay Hao
 * @Date 2018/6/6 17:45
 * @Version 1.0
 **/
public interface EntCreditService {

    /**
     * @Description 抓取工商信息
     * @Param
     * @return java.lang.String
     **/
    BaseResp<EntGsInfo> queryGsBaseInfo(EntParamType type, String key);

    /**
     * @Description 查询公司股权结构
     * @Param key 查询条件
     * @Param type  "1"-entId "2"-企业全名
     * @return
     **/
    BaseResp<EntEquityInfo> queryEquityInfo(EntParamType type, String key);

    BaseResp<List<EntEquityDetailInfo>> queryEquityDetailByParent(String entId, String parentNodeId);

    /**
     * @Description 爬取企业征信信息
     * @Param [entId, category]
     * @return java.lang.String
     **/
    BaseResp<String> crawlEleCreditInfoRaw(String entId, String category);

    /**
     * @Description 获取企业信息entId
     * @Param [key, type]
     * @return java.lang.String
     **/
    BaseResp<String> pullEntId(String keyword, String type);

    /**
     * @Description 根据简称取企业全称
     * @Param key 公司名称关键字
     * @return java.lang.String
     **/
    BaseResp<String> pullCompanyFullName(String key);

    /**
     * @Description 根据工商企业号取企业全称
     * @Param key 工商企业号
     * @return java.lang.String
     **/
    BaseResp<String> crawlCompanyNameByCreditCode(String key);

    /**
     * @Description 查询公司新闻
     * @Param companyId,公司entId
     * @return java.lang.String
     **/
    BaseResp<String> crawlPublicVoices(String companyId, String begin, String end);


    /**
     * @Description 查询公司股权结构
     * @Param companyId 公司entId
     * @Param version 类型 1-全部展现 2-部分脱敏 3-全部脱敏
     * @return java.lang.String
     **/
    BaseResp<String> crawlEntEquityControl(String companyId, String version);

}
