package com.ajayhao.mslab.stock.orm.mapper;

import com.ajayhao.mslab.stock.orm.entity.StockInfoDO;
import com.ajayhao.mslab.stock.orm.entity.StockInfoDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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