package com.ajayhao.mslab.crawler.repository.impl;

import com.ajayhao.mslab.core.util.DateUtil;
import com.ajayhao.mslab.crawler.enums.IsDeleteEnum;
import com.ajayhao.mslab.crawler.orm.entity.EntEquityDetailEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntEquityDetailEntityExample;
import com.ajayhao.mslab.crawler.orm.entity.EntInvestChainEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntInvestChainEntityExample;
import com.ajayhao.mslab.crawler.orm.mapper.DbIdMapper;
import com.ajayhao.mslab.crawler.orm.mapper.EntEquityDetailEntityMapper;
import com.ajayhao.mslab.crawler.orm.mapper.EntInvestChainEntityMapper;
import com.ajayhao.mslab.crawler.repository.AbstractRepository;
import com.ajayhao.mslab.crawler.repository.EntEquityInfoRepository;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static com.ajayhao.mslab.crawler.constant.CrawlerConstants.UNIQUE_TOKEN_VALID;


/**
 * @ClassName EntEquityInfoRepositoryImpl
 * @Description 股权信息dal逻辑实现
 * @Author Ajay Hao
 * @Date 2018/6/29 11:23
 * @Version 1.0
 **/

@Repository("entEquityInfoRepository")
public class EntEquityInfoRepositoryImpl extends AbstractRepository implements EntEquityInfoRepository {

    @Autowired
    private EntInvestChainEntityMapper entInvestChainEntityMapper;

    @Autowired
    private EntEquityDetailEntityMapper entEquityDetailEntityMapper;


    @Autowired
    private DbIdMapper dbIdMapper;

    /**
     * @Description 根据entId查询投资信息
     * @Param entId
     * @return EntGsInfoEntity
     **/
    @Override
    public EntInvestChainEntity queryInvestChainByEntId(String entId) {
        EntInvestChainEntityExample investChainEntityExample = new EntInvestChainEntityExample();
        investChainEntityExample.createCriteria().andEntIdEqualTo(entId).andUniqueTokenEqualTo(UNIQUE_TOKEN_VALID)
                                                    .andIsDeleteEqualTo(IsDeleteEnum.NO.getCode());
        List<EntInvestChainEntity> rslt = entInvestChainEntityMapper.selectByExample(investChainEntityExample);
        if(CollectionUtils.isEmpty(rslt)){
            return null;
        }

        return rslt.get(0);
    }

    /**
     * @Description 根据entId查询股权明细
     * @Param entId
     * @return List<EntEquityDetailEntity>
     **/
    @Override
    public List<EntEquityDetailEntity> queryEquityDetailEntity(String entId) {
        EntEquityDetailEntityExample equityDetailEntityExample = new EntEquityDetailEntityExample();
        equityDetailEntityExample.createCriteria().andEntIdEqualTo(entId).andUniqueTokenEqualTo(UNIQUE_TOKEN_VALID)
                                .andIsDeleteEqualTo(IsDeleteEnum.NO.getCode());
        List<EntEquityDetailEntity> rslt = entEquityDetailEntityMapper.selectByExample(equityDetailEntityExample);
        if(CollectionUtils.isEmpty(rslt)){
            return null;
        }
        return rslt;
    }

    /**
     * @Description 控股信息删除
     * @Param entId 元素企业Id
     * @Param softDelete 是否软删除
     * @return
     **/
    @Override
    public void deleteEntEquityDetail(String entId, boolean softDelete) {

        EntEquityDetailEntityExample conditions = new EntEquityDetailEntityExample();
        conditions.createCriteria()
                .andEntIdEqualTo(entId).andIsDeleteEqualTo(IsDeleteEnum.NO.getCode());

        if(softDelete) {
            EntEquityDetailEntity newEntity = new EntEquityDetailEntity();
            newEntity.setIsDelete(IsDeleteEnum.YES.getCode());
            entEquityDetailEntityMapper.updateByExampleSelective(newEntity,conditions);
        }else{
            entEquityDetailEntityMapper.deleteByExample(conditions);
        }

    }

    @Override
    public String insertNewInvestChainInfo(EntInvestChainEntity entInvestChainEntity) {
        super.prepareInsert(entInvestChainEntity);

        //填入id
        if(StringUtils.isEmpty(entInvestChainEntity.getId())){
            entInvestChainEntity.setId(String.valueOf(dbIdMapper.newQykgxxDbId()));
        }

        //补充拉取时间
        if(StringUtils.isEmpty(entInvestChainEntity.getPullDate())){
            entInvestChainEntity.setPullDate(DateUtil.formatDateByYYYY_MM_DD(new Date()));
        }

        //unique token
        if(StringUtils.isEmpty(entInvestChainEntity.getUniqueToken())) {
            entInvestChainEntity.setUniqueToken(UNIQUE_TOKEN_VALID);
        }

        entInvestChainEntityMapper.insert(entInvestChainEntity);

        return entInvestChainEntity.getId();
    }

    @Override
    public String insertNewEquityDetail(EntEquityDetailEntity entEquityDetailEntity) {
        super.prepareInsert(entEquityDetailEntity);

        //填入id
        if(StringUtils.isEmpty(entEquityDetailEntity.getId())){
            entEquityDetailEntity.setId(String.valueOf(dbIdMapper.newGqmxDbId()));
        }

        //补充拉取时间
        if(StringUtils.isEmpty(entEquityDetailEntity.getPullDate())){
            entEquityDetailEntity.setPullDate(DateUtil.formatDateByYYYY_MM_DD(new Date()));
        }

        //unique token
        if(StringUtils.isEmpty(entEquityDetailEntity.getUniqueToken())) {
            entEquityDetailEntity.setUniqueToken(UNIQUE_TOKEN_VALID);
        }

        entEquityDetailEntityMapper.insert(entEquityDetailEntity);

        return entEquityDetailEntity.getId();
    }

    /**
     * @Description 控股信息删除
     * @Param entId 元素企业Id
     * @Param softDelete 是否软删除
     * @return
     **/
    @Override
    public void deleteEntInvestChain(String entId, boolean softDelete) {

        EntInvestChainEntityExample conditions = new EntInvestChainEntityExample();
        conditions.createCriteria()
                .andEntIdEqualTo(entId).andIsDeleteEqualTo(IsDeleteEnum.NO.getCode());

        if(softDelete) {
            EntInvestChainEntity newEntity = new EntInvestChainEntity();
            newEntity.setIsDelete(IsDeleteEnum.YES.getCode());
            entInvestChainEntityMapper.updateByExampleSelective(newEntity,conditions);
        }else{
            entInvestChainEntityMapper.deleteByExample(conditions);
        }

    }
}
