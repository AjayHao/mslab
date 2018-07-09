package com.ajayhao.mslab.crawler.orm.mapper;

import com.ajayhao.mslab.crawler.orm.entity.EntGsInfoEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntGsInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntGsInfoEntityMapper {
    int deleteByExample(EntGsInfoEntityExample example);

    int deleteByPrimaryKey(String id);

    int insert(EntGsInfoEntity record);

    int insertSelective(EntGsInfoEntity record);

    List<EntGsInfoEntity> selectByExample(EntGsInfoEntityExample example);

    EntGsInfoEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EntGsInfoEntity record, @Param("example") EntGsInfoEntityExample example);

    int updateByExample(@Param("record") EntGsInfoEntity record, @Param("example") EntGsInfoEntityExample example);

    int updateByPrimaryKeySelective(EntGsInfoEntity record);

    int updateByPrimaryKey(EntGsInfoEntity record);
}