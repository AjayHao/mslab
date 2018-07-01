package com.ajayhao.mslab.crawler.orm.mapper;

import com.ajayhao.mslab.crawler.orm.entity.EntEquityDetailEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntEquityDetailEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntEquityDetailEntityMapper {
    int deleteByExample(EntEquityDetailEntityExample example);

    int deleteByPrimaryKey(String id);

    int insert(EntEquityDetailEntity record);

    int insertSelective(EntEquityDetailEntity record);

    List<EntEquityDetailEntity> selectByExample(EntEquityDetailEntityExample example);

    EntEquityDetailEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EntEquityDetailEntity record, @Param("example") EntEquityDetailEntityExample example);

    int updateByExample(@Param("record") EntEquityDetailEntity record, @Param("example") EntEquityDetailEntityExample example);

    int updateByPrimaryKeySelective(EntEquityDetailEntity record);

    int updateByPrimaryKey(EntEquityDetailEntity record);
}