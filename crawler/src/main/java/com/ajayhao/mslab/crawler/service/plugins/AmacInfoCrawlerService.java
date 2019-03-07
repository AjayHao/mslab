package com.ajayhao.mslab.crawler.service.plugins;

import com.ajayhao.mslab.crawler.dto.AmacExecutiveInfo;
import com.ajayhao.mslab.crawler.dto.AmacFundInfo;
import com.ajayhao.mslab.crawler.dto.AmacManagerInfo;
import com.ajayhao.mslab.crawler.remote.enums.AmacParamType;

import java.util.List;
import java.util.Map;

/**
 * AmacInfoCrawlerService
 *
 * @author Ajay Hao
 * @version 1.0
 * 协会信息爬虫解析
 * @date 2018/7/20 14:15
 **/
public interface AmacInfoCrawlerService {


    /**
     * 获取私募管理人总数
     * @param pageNo
     * @param size
     * @return Integer
     **/
    Integer pullAmacManagerTotalCount(Integer pageNo, Integer size);

    /**
     * 获取私募管理人总数
     *
     * @param pageNo
     * @param size
     * @param paramMap
     * @return Integer
     **/
    Integer pullAmacManagerTotalCount(Integer pageNo, Integer size, Map<String, Object> paramMap);

    /**
     * 获取私募管理人列表
     * @param pageNo
     * @param size
     * @return List<AmacManagerInfo>
     **/
    List<AmacManagerInfo> pullAmacManagerInfoList(Integer pageNo, Integer size);

    /**
     * 获取私募管理人列表
     * @param pageNo
     * @param size
     * @param params
     * @return List<AmacManagerInfo>
     **/
    List<AmacManagerInfo> pullAmacManagerInfoList(Integer pageNo, Integer size, Map<String, Object> params);

    /**
     * 获取私募基金列表
     * @param managerInfo
     * @return List<AmacFundInfo>
     **/
    List<AmacFundInfo> pullAmacFundInfoList(final AmacManagerInfo managerInfo);

    /**
     * 同步Amac管理人信息
     * @param
     * @return java.lang.String
     **/
    AmacManagerInfo refreshAmacManagerInfo(String managerName);

    /**
     * 同步Amac管理人旗下基金信息
     * @param
     * @return java.lang.String
     **/
    List<AmacFundInfo> refreshAmacFundInfoByManager(final AmacManagerInfo amacManagerInfo);


    /**
     * 获得Amac管理人旗下基金总数
     * @param managerName
     * @param defaultPageNo
     * @param defaultSize
     * @return
     */
    Integer pullAmacFundTotalCount(String managerName, Integer defaultPageNo, Integer defaultSize);

    AmacFundInfo refreshAmacFundInfo(String fundName);
}
