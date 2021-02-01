package com.ajayhao.mslab.crawler.service.impl;

import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.ajayhao.mslab.core.common.exception.BusinessBizException;
import com.ajayhao.mslab.core.util.DateUtil;
import com.ajayhao.mslab.crawler.config.AmacCrawlerConfig;
import com.ajayhao.mslab.crawler.dto.AmacFundInfo;
import com.ajayhao.mslab.crawler.dto.AmacManagerInfo;
import com.ajayhao.mslab.crawler.remote.enums.AmacParamType;
import com.ajayhao.mslab.crawler.service.AmacCrawlerService;
import com.ajayhao.mslab.crawler.service.EntCreditService;
import com.ajayhao.mslab.crawler.service.plugins.AmacInfoCrawlerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * AmacCrawlerServiceImpl
 * 管理人爬虫服务
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2018/7/20 15:18
 *
 **/
@Service
public class AmacCrawlerServiceImpl implements AmacCrawlerService {

    @Autowired
    private AmacInfoCrawlerService amacInfoCrawlerService;

    @Autowired
    private EntCreditService entCreditService;

    @Autowired
    private AmacCrawlerConfig amacCrawlerConfig;

    /**
     * @return
     * 查询Amac管理人信息
     * @param key 查询条件
     * @param type  "1"-协会注册编号 "2"-组织机构编码 "3"-企业全名
     **/
    @Override
    public AmacManagerInfo queryAmacManagerInfo(AmacParamType type, String key) {

        if (type == null || StringUtils.isBlank(key)) {
            throw new BusinessBizException(RespCodeType.INVALID_PARAM, StringUtils.join("type=", type, ";", "key=", key));
        }

        AmacManagerInfo amacManagerInfo = amacInfoCrawlerService.refreshAmacManagerInfo(key);
        return amacManagerInfo;
    }

    /**
     * 数据失效规则 有效期一周
     */
    private boolean isDataExpired(final AmacManagerInfo managerInfo) {
        return (managerInfo == null || StringUtils.isEmpty(managerInfo.getPullDate()) ||
                DateUtil.getDays(new Date(), DateUtil.parseDateByYYYY_MM_DD(managerInfo.getPullDate())) > amacCrawlerConfig.getExpireDays());
    }

    /**
     * @return
     * 查询Amac基金信息
     * @param key 查询条件
     * @param type  "1"-协会注册编号 "2"-组织机构编码 "3"-企业全名
     **/
    @Override
    public List<AmacFundInfo> queryAmacFundInfoByManager(AmacParamType type, String key) {

        if (type == null || StringUtils.isBlank(key)) {
            throw new BusinessBizException(RespCodeType.INVALID_PARAM, StringUtils.join("type=", type, ";", "key=", key));
        }

        AmacManagerInfo amacManagerInfo = queryAmacManagerInfo(type, key);
        List<AmacFundInfo> amacFundInfoList = null;
        //查询管理人发行的基金
        if(amacManagerInfo != null){
            amacFundInfoList = amacInfoCrawlerService.refreshAmacFundInfoByManager(amacManagerInfo);
        }

        return amacFundInfoList;
    }

    @Override
    public AmacFundInfo queryAmacFundInfo(String fundName) {
        AmacFundInfo amacFundInfo = amacInfoCrawlerService.refreshAmacFundInfo(fundName);
        return amacFundInfo;
    }

}
