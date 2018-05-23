package com.ajayhao.mslab.stock.dal.mapper;

import com.ajayhao.mslab.stock.dal.dataobject.StockInfoDO;
import com.ajayhao.mslab.stock.dal.dataobject.StockInfoDOExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StockInfoDO record);

    int insertSelective(StockInfoDO record);

    List<StockInfoDO> selectByExample(StockInfoDOExample example);

    StockInfoDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StockInfoDO record, @Param("example") StockInfoDOExample example);

    int updateByExample(@Param("record") StockInfoDO record, @Param("example") StockInfoDOExample example);

    int updateByPrimaryKeySelective(StockInfoDO record);

    int updateByPrimaryKey(StockInfoDO record);
}