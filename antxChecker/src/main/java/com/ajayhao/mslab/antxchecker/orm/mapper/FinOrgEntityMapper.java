package com.ajayhao.mslab.antxchecker.orm.mapper;

import com.ajayhao.mslab.antxchecker.orm.entity.FinOrgEntity;
import com.ajayhao.mslab.antxchecker.orm.entity.FinOrgEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinOrgEntityMapper {
    int deleteByExample(FinOrgEntityExample example);

    int insert(FinOrgEntity record);

    int insertSelective(FinOrgEntity record);

    List<FinOrgEntity> selectByExample(FinOrgEntityExample example);

    int updateByExampleSelective(@Param("record") FinOrgEntity record, @Param("example") FinOrgEntityExample example);

    int updateByExample(@Param("record") FinOrgEntity record, @Param("example") FinOrgEntityExample example);
}