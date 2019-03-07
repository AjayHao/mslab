package com.ajayhao.mslab.crawler.service;

import com.ajayhao.mslab.crawler.dto.AmacFundInfo;
import com.ajayhao.mslab.crawler.dto.AmacManagerInfo;
import com.ajayhao.mslab.crawler.remote.enums.AmacParamType;

import java.util.List;

/**
 * AmacCrawlerService
 * 协会信息爬虫服务
 * @author Ajay Hao
 * @date 2018/7/20 17:45
 * @version 1.0
 **/
public interface AmacCrawlerService {

    /**
     * @return
     * 查询Amac管理人信息
     * @param key 查询条件
     * @param type  "1"-协会注册编号 "2"-组织机构编码 "3"-企业全名
     **/
    AmacManagerInfo queryAmacManagerInfo(AmacParamType type, String key);

    /**
     * @return
     * 查询Amac基金信息
     * @param key 查询条件
     * @param type  "1"-协会注册编号 "2"-组织机构编码 "3"-企业全名
     **/
    List<AmacFundInfo> queryAmacFundInfoByManager(AmacParamType type, String key);

    /**
     * 查询基金信息
     * @param fundNo  产品代码
     */
    AmacFundInfo queryAmacFundInfo(String fundNo);

}
