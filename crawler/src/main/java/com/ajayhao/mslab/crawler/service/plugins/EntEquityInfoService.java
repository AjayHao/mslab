package com.ajayhao.mslab.crawler.service.plugins;

import com.ajayhao.mslab.crawler.dto.EntEquityDetailInfo;
import com.ajayhao.mslab.crawler.dto.EntEquityInfo;
import com.ajayhao.mslab.crawler.enums.EntParamType;
import com.ajayhao.mslab.crawler.orm.entity.EntControlEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntEquityDetailEntity;

import java.util.List;

/**
 * @Description 数据同步
 * @Param paramType 操作条件
 * @Param key 与paramType对应的操作变量
 * @return EntGsInfo
 **/
public interface EntEquityInfoService {

    /**
     * @Description 数据同步
     * @Param paramType 操作条件
     * @Param key 与paramType对应的操作变量
     * @return EntEquityInfo
     **/
    EntEquityInfo refreshEntEquityInfo(EntParamType paramType, String key);

    /**
     * @Description 解析股权信息
     * @Param oldEntControlEntity 控制人信息
     * @Param oldEquityDetailEntityList 股权详情
     * @return EntEquityInfo
     **/
    EntEquityInfo resolveEquityInfo(List<EntControlEntity> oldEntControlEntity, List<EntEquityDetailEntity> oldEquityDetailEntityList);

    /**
     * @Description 解析股权详情
     * @Param equityDetailEntityList 股权详情
     * @return List<EntEquityDetailInfo>
     **/
    List<EntEquityDetailInfo> resolveEntEquityDetailInfo(List<EntEquityDetailEntity> equityDetailEntityList);
}
