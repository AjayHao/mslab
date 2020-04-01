package com.ajayhao.mslab.crawler.remote.impl;

import com.ajayhao.mslab.core.common.exception.BusinessBizException;
import com.ajayhao.mslab.crawler.config.AmacCrawlerConfig;
import com.ajayhao.mslab.crawler.dto.AmacExecutiveInfo;
import com.ajayhao.mslab.crawler.dto.AmacFundInfo;
import com.ajayhao.mslab.crawler.dto.AmacManagerCreditInfo;
import com.ajayhao.mslab.crawler.dto.AmacManagerInfo;
import com.ajayhao.mslab.crawler.helper.AmacCrawlerHelper;
import com.ajayhao.mslab.crawler.remote.AmacRemoteService;
import com.ajayhao.mslab.crawler.remote.dto.AmacFundRemoteResp;
import com.ajayhao.mslab.crawler.remote.dto.AmacManagerRemoteResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ajayhao.mslab.core.common.enums.RespCodeType.REMOTE_INVOKE_ERROR;
import static com.ajayhao.mslab.core.common.enums.RespCodeType.TOO_MANY_RESULTS;
import static com.ajayhao.mslab.crawler.constant.CrawlerConstants.DEFAULT_MAP_SIZE;
import static com.ajayhao.mslab.crawler.remote.constant.RemoteConstant.AMAC_FUND_DETAIL_URL;
import static com.ajayhao.mslab.crawler.remote.constant.RemoteConstant.AMAC_MANAGER_DETAIL_URL;

/**
 * AmacRemoteServiceImpl
 *
 * @author Ajay Hao
 * @version 1.0
 * 爬虫远程服务
 * @date 2018/7/18 9:03
 **/
@Service("amacRemoteService")
@Slf4j
public class AmacRemoteServiceImpl implements AmacRemoteService {

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    private AmacCrawlerHelper amacCrawlerHelper;

    @Autowired
    private AmacCrawlerConfig amacCrawlerConfig;

    /**
     * @return AmacManagerInfo
     * 获取私募管理人- 基本信息
     * @param managerName
     **/
    @Override
    public AmacManagerInfo pullAmacManagerInfo(String managerName) {
        //构造参数
        Map<String, String> paramMap = amacCrawlerHelper.buildAmacKeywordQueryParam(managerName);

        String url = amacCrawlerHelper.buildAmacManagerDefaultUrl();
        //提交post请求
        AmacManagerRemoteResp remoteResp = restTemplate.postForObject(url, paramMap, AmacManagerRemoteResp.class);
        AmacManagerInfo amacManagerInfo = null;
        if (CollectionUtils.isNotEmpty(remoteResp.getContent())){
            if (remoteResp.getContent().size() > 1) {
                throw new BusinessBizException(TOO_MANY_RESULTS);
            } else {
                amacManagerInfo = remoteResp.getContent().get(0);
            }
        }

        return amacManagerInfo;
    }

    /**
     * @return AmacManagerInfo
     * 获取私募管理人- 明细信息
     * @param urlParam
     **/
    @Override
    public AmacManagerInfo pullAmacManagerDetail(String urlParam) {
        AmacManagerInfo amacManagerInfo = null;
        List<AmacExecutiveInfo> amacEmployerInfoList = null;
        List<AmacManagerCreditInfo> amacManagerCreditInfoList = null;
        try {
            //获取指定网址的页面内容
            String managerUrl = String.format(AMAC_MANAGER_DETAIL_URL, urlParam);
            //设置代理
            Document document = Jsoup.connect(managerUrl).timeout(amacCrawlerConfig.getTimeout()).get();
            amacManagerInfo = amacCrawlerHelper.resolveAmacManagerInfoResp(document);
            amacEmployerInfoList = amacCrawlerHelper.resolveAmacEmployerInfoResp(document);
            amacManagerCreditInfoList = amacCrawlerHelper.resolveAmacCreditInfoResp(amacManagerInfo.getRegisterNo(), document);
            amacManagerInfo.setExecutiveInfo(amacEmployerInfoList);
            amacManagerInfo.setCreditInfo(amacManagerCreditInfoList);
        } catch (Exception e) {
            log.error("爬取Amac私募管理人明细信息异常", e);
            throw new BusinessBizException(REMOTE_INVOKE_ERROR);
        }

        return amacManagerInfo;
    }

    /**
     * @return AmacManagerInfo
     * 获取私募管理人总数
     * @param pageNo
     * @param size
     **/
    @Override
    public Integer pullAmacManagerTotalCount(Integer pageNo, Integer size) {
        //构造参数
        return pullAmacManagerTotalCount(pageNo, size, null);
    }

    /**
     * @return AmacManagerInfo
     * 获取私募管理人总数
     * @param pageNo
     * @param size
     * @param params
     **/
    @Override
    public Integer pullAmacManagerTotalCount(Integer pageNo, Integer size, Map<String, Object> params) {
        //构造参数
        Map<String,Object> paramMap = (params != null) ? params : new HashMap<>(DEFAULT_MAP_SIZE);

        String url = amacCrawlerHelper.buildAmacManagerUrl(pageNo, size);
        //提交post请求
        AmacManagerRemoteResp remoteResp = restTemplate.postForObject(url, paramMap, AmacManagerRemoteResp.class);
        return remoteResp.getTotalElements();
    }

    /**
     * @return AmacManagerInfo
     * 获取私募管理人信息列表
     * @param pageNo
     * @param size
     **/
    @Override
    public List<AmacManagerInfo> pullAmacManagerInfoList(Integer pageNo, Integer size) {
        return pullAmacManagerInfoList(pageNo, size, null);
    }


    /**
     * @return AmacManagerInfo
     * 获取私募管理人信息列表 , 定制化参数，外部传入
     * @param pageNo
     * @param size
     * @param params
     **/
    @Override
    public List<AmacManagerInfo> pullAmacManagerInfoList(Integer pageNo, Integer size, Map<String, Object> params) {
        String url = amacCrawlerHelper.buildAmacManagerUrl(pageNo, size);
        //提交post请求
        Map<String,Object> paramMap = (params != null) ? params : new HashMap<>(DEFAULT_MAP_SIZE);

        AmacManagerRemoteResp remoteResp = restTemplate.postForObject(url, paramMap, AmacManagerRemoteResp.class);
        List<AmacManagerInfo> amacManagerInfoList = null;
        if (remoteResp.getContent() != null){
            amacManagerInfoList = remoteResp.getContent();
        }
        return amacManagerInfoList;
    }

    /**
     * @return AmacFundInfo
     * 获取私募基金信息
     * @param fundName
     **/
    @Override
    public AmacFundInfo pullAmacFundBasicInfo(String fundName) {
        //构造参数
        Map<String, String> paramMap = amacCrawlerHelper.buildAmacKeywordQueryParam(fundName);

        String url = amacCrawlerHelper.buildAmacFundDefaultUrl();
        //提交post请求
        AmacFundRemoteResp remoteResp = restTemplate.postForObject(url, paramMap, AmacFundRemoteResp.class);
        AmacFundInfo amacFundInfo = null;
        if (CollectionUtils.isEmpty(remoteResp.getContent()) ||
                remoteResp.getContent().size() > 1) {
            throw new BusinessBizException(TOO_MANY_RESULTS);
        } else {
            amacFundInfo = remoteResp.getContent().get(0);
        }
        return amacFundInfo;
    }

    /**
     * @return AmacFundInfo
     * 获取私募基金信息 - 明细信息
     * @param urlParam
     **/
    @Override
    public AmacFundInfo pullAmacFundDetail(String urlParam) {
        AmacFundInfo amacFundInfo = null;
        try {
            //获取指定网址的页面内容
            String fundUrl = String.format(AMAC_FUND_DETAIL_URL, urlParam);

            Document document = Jsoup.connect(fundUrl).timeout(amacCrawlerConfig.getTimeout()).get();
            amacFundInfo = amacCrawlerHelper.resolveAmacFundInfoResp(document);
        } catch (Exception e) {
            log.error("爬取Amac私募基金明细信息异常", e);
            throw new BusinessBizException(REMOTE_INVOKE_ERROR);
        }

        return amacFundInfo;
    }


    /**
     * @return AmacManagerInfo
     * 获取私募基金总数
     * @param keyWord
     * @param pageNo
     * @param size
     **/
    @Override
    public Integer pullAmacFundTotalCount(String keyWord, Integer pageNo, Integer size) {
        //构造参数
        Map<String, String> paramMap = amacCrawlerHelper.buildAmacKeywordQueryParam(keyWord);
        String url = amacCrawlerHelper.buildAmacFundUrl(pageNo, size);
        //提交post请求
        AmacFundRemoteResp remoteResp = restTemplate.postForObject(url, paramMap, AmacFundRemoteResp.class);
        return remoteResp.getTotalElements();
    }


    /**
     * 获取私募基金信息
     * @param managerName
     * @param pageNo
     * @param pageSize
     * @return List<AmacFundInfo>
     **/
    @Override
    public List<AmacFundInfo> pullAmacFundsByManager(String managerName, Integer pageNo, Integer pageSize) {
        //构造参数
        Map<String, String> paramMap = amacCrawlerHelper.buildAmacKeywordQueryParam(managerName);

        String url = amacCrawlerHelper.buildAmacFundUrl(pageNo, pageSize);
        //提交post请求
        AmacFundRemoteResp remoteResp = restTemplate.postForObject(url, paramMap, AmacFundRemoteResp.class);
        List<AmacFundInfo> amacFundInfoList = null;
        if (remoteResp.getContent() != null) {
            amacFundInfoList = remoteResp.getContent();
        }
        return amacFundInfoList;
    }

}
