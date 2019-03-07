package com.ajayhao.mslab.crawler.remote;

import com.ajayhao.mslab.crawler.dto.AmacFundInfo;
import com.ajayhao.mslab.crawler.dto.AmacManagerInfo;

import java.util.List;
import java.util.Map;

/**
 * AmacRemoteService
 *
 * @author Ajay Hao
 * @version 1.0
 * 爬虫远程服务
 * @date 2018/7/18 9:03
 **/
public interface AmacRemoteService {

    Integer pullAmacManagerTotalCount(Integer pageNo, Integer size, Map<String, Object> params);

    List<AmacManagerInfo> pullAmacManagerInfoList(Integer pageNo, Integer size);

    List<AmacManagerInfo> pullAmacManagerInfoList(Integer pageNo, Integer size, Map<String, Object> params);

    AmacFundInfo pullAmacFundBasicInfo(String fundName);

    Integer pullAmacFundTotalCount(String keyWord, Integer pageNo, Integer size);

    List<AmacFundInfo> pullAmacFundsByManager(String managerName, Integer pageNo, Integer pageSize);

    Integer pullAmacManagerTotalCount(Integer pageNo, Integer size);

    AmacManagerInfo pullAmacManagerInfo(String managerName);

    AmacManagerInfo pullAmacManagerDetail(String urlParam);

    AmacFundInfo pullAmacFundDetail(String urlParam);
}
