package com.ajayhao.mslab.crawler.orm.mapper;

import com.ajayhao.mslab.crawler.orm.entity.EntControlEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntControlEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntControlEntityMapper {
    int deleteByExample(EntControlEntityExample example);

    int deleteByPrimaryKey(String id);

    int insert(EntControlEntity record);

    List<EntControlEntity> selectByExample(EntControlEntityExample example);

    EntControlEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EntControlEntity record, @Param("example") EntControlEntityExample example);

    int updateByPrimaryKeySelective(EntControlEntity record);
}