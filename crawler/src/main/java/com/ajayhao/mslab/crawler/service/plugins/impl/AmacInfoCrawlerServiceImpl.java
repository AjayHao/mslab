package com.ajayhao.mslab.crawler.service.plugins.impl;

import com.ajayhao.mslab.crawler.config.AmacCrawlerConfig;
import com.ajayhao.mslab.crawler.dto.AmacFundInfo;
import com.ajayhao.mslab.crawler.dto.AmacManagerInfo;
import com.ajayhao.mslab.crawler.helper.BeanEntityFactory;
import com.ajayhao.mslab.crawler.remote.AmacRemoteService;
import com.ajayhao.mslab.crawler.service.plugins.AmacInfoCrawlerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.ajayhao.mslab.crawler.remote.constant.RemoteConstant.AMAC_DEFAULT_PAGE_NO;
import static com.ajayhao.mslab.crawler.remote.constant.RemoteConstant.AMAC_DEFAULT_PAGE_SIZE;

/**
 * AmacInfoCrawlerServiceImpl
 * 协会爬虫解析
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2018/7/20 14:18
 **/
@Service("amacInfoCrawlerService")
@Slf4j
public class AmacInfoCrawlerServiceImpl implements AmacInfoCrawlerService {


    @Autowired
    private AmacRemoteService amacRemoteService;

    @Autowired
    private AmacCrawlerConfig amacCrawlerConfig;



    /**
     * 获取私募管理人总数
     *
     * @param pageNo
     * @param size
     * @return Integer
     **/
    @Override
    public Integer pullAmacManagerTotalCount(Integer pageNo, Integer size) {
        return pullAmacManagerTotalCount(pageNo, size, null);
    }

    /**
     * 获取私募管理人总数
     *
     * @param pageNo
     * @param size
     * @param paramMap
     * @return Integer
     **/
    @Override
    public Integer pullAmacManagerTotalCount(Integer pageNo, Integer size, Map<String, Object> paramMap) {
        return amacRemoteService.pullAmacManagerTotalCount(pageNo, size, paramMap);
    }

    /**
     * 获取私募管理人列表
     * @param pageNo
     * @param size
     * @param params
     * @return List<AmacManagerInfo>
     **/
    @Override
    public List<AmacManagerInfo> pullAmacManagerInfoList(Integer pageNo, Integer size, Map<String, Object> params) {
        // 1. 基本信息
        List<AmacManagerInfo> amacManagerInfoList = amacRemoteService.pullAmacManagerInfoList(pageNo, size, params);
        if (CollectionUtils.isNotEmpty(amacManagerInfoList)) {
            for (AmacManagerInfo amacManagerInfo : amacManagerInfoList) {
                log.info("开始爬取管理人明细：{}", amacManagerInfo.getManagerName());
                try {
                    // 2. 明细
                    AmacManagerInfo amacManagerDetail = amacRemoteService.pullAmacManagerDetail(amacManagerInfo.getUrl());
                    // 3. 合并数据
                    BeanEntityFactory.mergeIntoAmacManagerInfo(amacManagerDetail, amacManagerInfo);
                } catch (Exception e) {
                    log.error("爬取管理人明细异常：{}", amacManagerInfo.getManagerName());
                }
            }
        }
        return amacManagerInfoList;
    }

    /**
     * 获取私募管理人列表
     * @param pageNo
     * @param size
     * @return List<AmacManagerInfo>
     **/
    @Override
    public List<AmacManagerInfo> pullAmacManagerInfoList(Integer pageNo, Integer size) {
        return pullAmacManagerInfoList(pageNo, size, null);
    }


    @Override
    public List<AmacFundInfo> pullAmacFundInfoList(final AmacManagerInfo amacManagerInfo) {
        Integer defaultPageNo = amacCrawlerConfig.getPageNo() != null ? amacCrawlerConfig.getPageNo() : AMAC_DEFAULT_PAGE_NO;
        Integer defaultSize = amacCrawlerConfig.getSize() != null ? amacCrawlerConfig.getSize() : AMAC_DEFAULT_PAGE_SIZE;
        List<AmacFundInfo> fundInfoList = null;
        Integer totalCount = pullAmacFundTotalCount(amacManagerInfo.getManagerName(), defaultPageNo, defaultSize);
        if (totalCount != null && totalCount > 0) {
            int pages = (totalCount - 1) / defaultSize + 1;
            fundInfoList = new ArrayList<>();
            for (int i = 0; i < pages; i++) {
                List<AmacFundInfo> partialFundInfoList = amacRemoteService.pullAmacFundsByManager(amacManagerInfo.getManagerName(), i, defaultSize);
                //补充每条明细
                for (AmacFundInfo fundInfo : partialFundInfoList) {
                    AmacFundInfo fundDetail = amacRemoteService.pullAmacFundDetail(fundInfo.getUrl());
                    fundInfo.setManagerRegNo(amacManagerInfo.getRegisterNo());
                    // 合并数据
                    BeanEntityFactory.mergeIntoAmacFundInfo(fundDetail, fundInfo);
                    fundInfoList.add(fundInfo);
                }
            }
        }
        return fundInfoList;
    }

    /**
     * 同步Amac管理人信息
     *
     * @param managerName
     * @return java.lang.String
     **/
    @Override
    public AmacManagerInfo refreshAmacManagerInfo(String managerName) {
        //重新拉取
        // 1. 基本信息
        AmacManagerInfo amacManagerInfo = amacRemoteService.pullAmacManagerInfo(managerName);
        if (amacManagerInfo != null) {
            // 2. 明细
            AmacManagerInfo amacManagerDetail = amacRemoteService.pullAmacManagerDetail(amacManagerInfo.getUrl());
            // 3. 合并数据
            BeanEntityFactory.mergeIntoAmacManagerInfo(amacManagerDetail, amacManagerInfo);
            /* 写数
            AmacManagerEntity newAmacManagerEntity = BeanEntityFactory.fromAmacManagerBean(amacManagerInfo);
            List<AmacExecutiveEntity> newAmacExecutiveEntities = BeanEntityFactory.fromAmacExecutiveBeanList(amacManagerInfo.getExecutiveInfo());
            List<AmacManagerCreditEntity> newAmacManagerCreditEntities = BeanEntityFactory.fromAmacManagerCreditBeanList(amacManagerInfo.getCreditInfo());
            updateAmacManagerInfo(amacManagerInfo, newAmacManagerEntity, newAmacExecutiveEntities, newAmacManagerCreditEntities);
            */
        }
        return amacManagerInfo;
    }

    /**
     * 同步Amac管理人旗下基金信息
     *
     * @param amacManagerInfo
     * @return java.lang.String
     **/
    @Override
    public List<AmacFundInfo> refreshAmacFundInfoByManager(final AmacManagerInfo amacManagerInfo) {
        //重新拉取
        List<AmacFundInfo> amacFundInfoList = pullAmacFundInfoList(amacManagerInfo);
        if (CollectionUtils.isNotEmpty(amacFundInfoList)) {
            //补充每条明细
            for (AmacFundInfo fundInfo : amacFundInfoList) {
                AmacFundInfo fundDetail = amacRemoteService.pullAmacFundDetail(fundInfo.getUrl());
                fundInfo.setManagerRegNo(amacManagerInfo.getRegisterNo());
                // 合并数据
                BeanEntityFactory.mergeIntoAmacFundInfo(fundDetail, fundInfo);
            }/*
            // 更新库表数据
            List<AmacFundEntity> amacFundEntityList = BeanEntityFactory.fromAmacFundBeanList(amacFundInfoList);
            updateAmacFundInfoList(amacManagerInfo, amacFundEntityList);*/
        }
        return amacFundInfoList;
    }

    @Override
    public Integer pullAmacFundTotalCount(String managerName, Integer pageNo, Integer size) {
        return amacRemoteService.pullAmacFundTotalCount(managerName, pageNo, size);
    }


    /**
     * 同步Amac基金信息
     *
     * @param fundName
     * @return java.lang.String
     **/
    @Override
    public AmacFundInfo refreshAmacFundInfo(String fundName) {
        //重新拉取
        // 1. 基本信息
        AmacFundInfo fundInfo = amacRemoteService.pullAmacFundBasicInfo(fundName);
        if (fundInfo != null) {
            // 2. 明细
            AmacFundInfo amacFundDetail = amacRemoteService.pullAmacFundDetail(fundInfo.getUrl());
            // 3. 合并数据
            BeanEntityFactory.mergeIntoAmacFundInfo(amacFundDetail, fundInfo);
            /* 写数
            AmacManagerEntity newAmacManagerEntity = BeanEntityFactory.fromAmacManagerBean(amacManagerInfo);
            List<AmacExecutiveEntity> newAmacExecutiveEntities = BeanEntityFactory.fromAmacExecutiveBeanList(amacManagerInfo.getExecutiveInfo());
            List<AmacManagerCreditEntity> newAmacManagerCreditEntities = BeanEntityFactory.fromAmacManagerCreditBeanList(amacManagerInfo.getCreditInfo());
            updateAmacManagerInfo(amacManagerInfo, newAmacManagerEntity, newAmacExecutiveEntities, newAmacManagerCreditEntities);
            */
        }
        return fundInfo;
    }

}
