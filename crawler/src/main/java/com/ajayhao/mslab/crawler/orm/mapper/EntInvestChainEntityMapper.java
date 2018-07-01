package com.ajayhao.mslab.crawler.orm.mapper;

import com.ajayhao.mslab.crawler.orm.entity.EntInvestChainEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntInvestChainEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntInvestChainEntityMapper {
    int deleteByExample(EntInvestChainEntityExample example);

    int deleteByPrimaryKey(String id);

    int insert(EntInvestChainEntity record);

    List<EntInvestChainEntity> selectByExample(EntInvestChainEntityExample example);

    EntInvestChainEntity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EntInvestChainEntity record, @Param("example") EntInvestChainEntityExample example);

    int updateByPrimaryKeySelective(EntInvestChainEntity record);
}