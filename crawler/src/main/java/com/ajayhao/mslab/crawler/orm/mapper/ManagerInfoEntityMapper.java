package com.ajayhao.mslab.crawler.orm.mapper;

import com.ajayhao.mslab.crawler.orm.entity.ManagerInfoEntity;
import com.ajayhao.mslab.crawler.orm.entity.ManagerInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerInfoEntityMapper {
    int deleteByExample(ManagerInfoEntityExample example);

    int deleteByPrimaryKey(String id);

    int insert(ManagerInfoEntity record);

    int insertSelective(ManagerInfoEntity record);

    List<ManagerInfoEntity> selectByExample(ManagerInfoEntityExample example);

    ManagerInfoEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ManagerInfoEntity record, @Param("example") ManagerInfoEntityExample example);

    int updateByExample(@Param("record") ManagerInfoEntity record, @Param("example") ManagerInfoEntityExample example);

    int updateByPrimaryKeySelective(ManagerInfoEntity record);

    int updateByPrimaryKey(ManagerInfoEntity record);
}