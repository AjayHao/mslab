package com.ajayhao.mslab.crawler.repository;

import com.ajayhao.mslab.crawler.orm.entity.EntControlEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntEquityDetailEntity;

import java.util.List;

/**
 * @InterfaceName EntEquityInfoRepository
 * @Description 股权信息dal逻辑
 * @Author Ajay Hao
 * @Date 2018/6/29 11:22
 * @Version 1.0
 **/
public interface EntEquityInfoRepository {

    /**
     * @Description 根据entId查询大股东投资信息
     * @Param endId
     * @return List<EntControlEntity>
     **/
    List<EntControlEntity> queryEntControlByEntId(String entId);

    /**
     * @Description 根据entId查询股权信息
     * @Param endId
     * @return List<EntEquityDetailEntity>
     **/
    List<EntEquityDetailEntity> queryEquityDetailEntity(String entId);

    /**
     * @Description 控股信息删除
     * @Param entId 元素企业Id
     * @Param softDelete 是否软删除
     * @return
     **/
    void deleteEntControl(String entId, boolean softDelete);

    /**
     * @Description 股权信息删除
     * @Param entId 元素企业Id
     * @Param softDelete 是否软删除
     * @return
     **/
    void deleteEntEquityDetail(String entId, boolean b);

    /**
     * @Description 写入大股东信息
     * @Param entControlEntity 大股东信息实体
     * @return
     **/
    String insertNewEntControl(EntControlEntity entControlEntity);

    /**
     * @Description 写入股权信息
     * @Param entEquityDetailEntity 股权信息明细
     * @return
     **/
    String insertNewEquityDetail(EntEquityDetailEntity entEquityDetailEntity);
}
