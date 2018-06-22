package com.ajayhao.mslab.crawler.service;

import com.ajayhao.mslab.crawler.dto.ElecreditResp;

/**
 * @ClassName CrawlerService
 * @Description 爬虫服务
 * @Author Ajay Hao
 * @Date 2018/6/6 17:45
 * @Version 1.0
 **/
public interface CrawlerService {
    /**
     * @Description 爬取企业征信信息
     * @Param [entId, category]
     * @return java.lang.String
     **/
    ElecreditResp crawlEleCreditInfo(String entId, String category);

    /**
     * @Description 获取企业信息entId
     * @Param [key, type]
     * @return java.lang.String
     **/
    ElecreditResp crawlEntId(String keyword, String type);

    /**
     * @Description 根据简称取企业全称
     * @Param key 公司名称关键字
     * @return java.lang.String
     **/
    ElecreditResp crawlCompanyFullName(String key);

    /**
     * @Description 根据工商企业号取企业全称
     * @Param key 工商企业号
     * @return java.lang.String
     **/
    ElecreditResp crawlCompanyNameByCreditCode(String key);

    /**
     * @Description 查询公司新闻
     * @Param companyId,公司entId
     * @return java.lang.String
     **/
    ElecreditResp crawlCompanyNews(String companyId, String category, String begin, String end);
}
