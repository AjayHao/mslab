package com.ajayhao.mslab.crawler.repository;

import com.ajayhao.mslab.crawler.orm.entity.EntGsInfoEntity;

/**
 * @InterfaceName EntGsInfoRepository
 * @Description 工商信息dal逻辑
 * @Author Ajay Hao
 * @Date 2018/6/29 11:22
 * @Version 1.0
 **/
public interface EntGsInfoRepository {
    /**
     * @Description 写入工商信息
     * @Param entGsInfoEntity 工商信息实体
     * @return java.lang.String
     **/
    String insertNewGsInfo(EntGsInfoEntity entGsInfoEntity);

    /**
     * @Description 根据全名查询工商信息
     * @Param entName 企业全名
     * @return EntGsInfoEntity
     **/
    EntGsInfoEntity queryGsInfoByEntId(String entId);

    /**
     * @Description 工商信息删除
     * @Param entId 元素企业Id
     * @Param softDelete 是否软删除
     * @return
     **/
    void deleteEntGsInfo(String entId, boolean softDelete);
}
