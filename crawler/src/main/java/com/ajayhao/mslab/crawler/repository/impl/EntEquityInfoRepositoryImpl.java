package com.ajayhao.mslab.crawler.repository.impl;

import com.ajayhao.mslab.core.util.DateUtil;
import com.ajayhao.mslab.crawler.enums.IsDeleteEnum;
import com.ajayhao.mslab.crawler.orm.entity.EntControlEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntEquityDetailEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntEquityDetailEntityExample;
import com.ajayhao.mslab.crawler.orm.entity.EntControlEntityExample;
import com.ajayhao.mslab.crawler.orm.mapper.DbIdMapper;
import com.ajayhao.mslab.crawler.orm.mapper.EntEquityDetailEntityMapper;
import com.ajayhao.mslab.crawler.orm.mapper.EntControlEntityMapper;
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
    private EntControlEntityMapper entControlEntityMapper;

    @Autowired
    private EntEquityDetailEntityMapper entEquityDetailEntityMapper;


    @Autowired
    private DbIdMapper dbIdMapper;

    /**
     * @Description 根据entId查询大股东信息
     * @Param entId
     * @return List<EntControlEntity>
     **/
    @Override
    public List<EntControlEntity> queryEntControlByEntId(String entId) {
        EntControlEntityExample entControlEntityExample = new EntControlEntityExample();
        entControlEntityExample.createCriteria().andEntIdEqualTo(entId).andUniqueTokenEqualTo(UNIQUE_TOKEN_VALID)
                                                    .andIsDeleteEqualTo(IsDeleteEnum.NO.getCode());
        List<EntControlEntity> rslt = entControlEntityMapper.selectByExample(entControlEntityExample);
        if(CollectionUtils.isEmpty(rslt)){
            return null;
        }

        return rslt;
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
     * @Description 根据entId, 父节点查询股权明细
     * @Param entId
     * @Param parentNodeId
     * @return List<EntEquityDetailEntity>
     **/
    @Override
    public List<EntEquityDetailEntity> queryEquityDetailByParentNode(String entId, String parentNodeId) {
        EntEquityDetailEntityExample equityDetailEntityExample = new EntEquityDetailEntityExample();
        equityDetailEntityExample.createCriteria()
                .andEntIdEqualTo(entId)
                .andParentNodeIdEqualTo(parentNodeId)
                .andUniqueTokenEqualTo(UNIQUE_TOKEN_VALID)
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
    public String insertNewEntControl(EntControlEntity entControlEntity) {
        super.prepareInsert(entControlEntity);

        //填入id
        if(StringUtils.isEmpty(entControlEntity.getId())){
            entControlEntity.setId(String.valueOf(dbIdMapper.newQykgxxDbId()));
        }

        //补充拉取时间
        if(StringUtils.isEmpty(entControlEntity.getPullDate())){
            entControlEntity.setPullDate(DateUtil.formatDateByYYYY_MM_DD(new Date()));
        }

        //unique token
        if(StringUtils.isEmpty(entControlEntity.getUniqueToken())) {
            entControlEntity.setUniqueToken(UNIQUE_TOKEN_VALID);
        }

        entControlEntityMapper.insert(entControlEntity);

        return entControlEntity.getId();
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
    public void deleteEntControl(String entId, boolean softDelete) {

        EntControlEntityExample conditions = new EntControlEntityExample();
        conditions.createCriteria()
                .andEntIdEqualTo(entId).andIsDeleteEqualTo(IsDeleteEnum.NO.getCode());

        if(softDelete) {
            EntControlEntity newEntity = new EntControlEntity();
            newEntity.setIsDelete(IsDeleteEnum.YES.getCode());
            entControlEntityMapper.updateByExampleSelective(newEntity,conditions);
        }else{
            entControlEntityMapper.deleteByExample(conditions);
        }

    }
}
