package com.ajayhao.mslab.crawler.service.plugins;

import com.ajayhao.mslab.crawler.dto.EntGsInfo;
import com.ajayhao.mslab.crawler.enums.EntParamType;
import com.ajayhao.mslab.crawler.orm.entity.EntGsInfoEntity;

/**
 * @Description 数据同步
 * @Param paramType 操作条件
 * @Param key 与paramType对应的操作变量
 * @return EntGsInfo
 **/
public interface EntBaseInfoService {

    /**
     * @Description 根据关键字查entId
     * @Param key 与paramType对应的操作变量
     * @Param type 参数类型
     * @return String
     **/
    String getEntIdByKey(EntParamType type, String key);

    /**
     * @Description 数据同步
     * @Param paramType 操作条件
     * @Param key 与paramType对应的操作变量
     * @return EntGsInfo
     **/
    EntGsInfo refreshEntBaseInfo(EntParamType paramType, String key);

    EntGsInfo resolveEntBaseInfo(EntGsInfoEntity oldEntGsInfoEntity);
}
