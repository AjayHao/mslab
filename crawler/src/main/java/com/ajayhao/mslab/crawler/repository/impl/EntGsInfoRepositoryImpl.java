package com.ajayhao.mslab.crawler.repository.impl;

import com.ajayhao.mslab.core.util.DateUtil;
import com.ajayhao.mslab.crawler.enums.IsDeleteEnum;
import com.ajayhao.mslab.crawler.orm.entity.EntGsInfoEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntGsInfoEntityExample;
import com.ajayhao.mslab.crawler.orm.mapper.DbIdMapper;
import com.ajayhao.mslab.crawler.orm.mapper.EntGsInfoEntityMapper;
import com.ajayhao.mslab.crawler.repository.AbstractRepository;
import com.ajayhao.mslab.crawler.repository.EntGsInfoRepository;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static com.ajayhao.mslab.crawler.constant.CrawlerConstants.UNIQUE_TOKEN_VALID;


/**
 * @ClassName EntGsInfoRepositoryImpl
 * @Description 工商信息dal逻辑实现
 * @Author Ajay Hao
 * @Date 2018/6/29 11:23
 * @Version 1.0
 **/

@Repository("entGsInfoRepository")
public class EntGsInfoRepositoryImpl extends AbstractRepository implements EntGsInfoRepository{

    @Autowired
    private EntGsInfoEntityMapper entGsInfoEntityMapper;

    @Autowired
    private DbIdMapper dbIdMapper;

    /**
     * @Description 写入工商信息
     * @Param entGsInfoEntity 工商信息实体
     * @return java.lang.String
     **/
    @Override
    public String insertNewGsInfo(EntGsInfoEntity entGsInfoEntity) {
        super.prepareInsert(entGsInfoEntity);

        //填入id
        if(StringUtils.isEmpty(entGsInfoEntity.getId())){
            entGsInfoEntity.setId(String.valueOf(dbIdMapper.newGsxxDbId()));
        }

        //补充拉取时间
        if(StringUtils.isEmpty(entGsInfoEntity.getPullDate())){
            entGsInfoEntity.setPullDate(DateUtil.formatDateByYYYY_MM_DD(new Date()));
        }

        //unique token
        if(StringUtils.isEmpty(entGsInfoEntity.getUniqueToken())) {
            entGsInfoEntity.setUniqueToken(UNIQUE_TOKEN_VALID);
        }

        entGsInfoEntityMapper.insert(entGsInfoEntity);

        return entGsInfoEntity.getId();
    }

    /**
     * @Description 根据entId查询工商信息
     * @Param entName 企业全名
     * @return EntGsInfoEntity
     **/
    @Override
    public EntGsInfoEntity queryGsInfoByEntId(String entId) {
        EntGsInfoEntityExample gsInfoEntityExample = new EntGsInfoEntityExample();
        gsInfoEntityExample.createCriteria().andEntIdEqualTo(entId).andIsDeleteEqualTo(IsDeleteEnum.NO.getCode());
        List<EntGsInfoEntity> rslt = entGsInfoEntityMapper.selectByExample(gsInfoEntityExample);
        if(CollectionUtils.isEmpty(rslt)){
            return null;
        }

        return rslt.get(0);
    }

    /**
     * @Description 工商信息删除
     * @Param entId 元素企业Id
     * @Param softDelete 是否软删除
     * @return
     **/
    @Override
    public void deleteEntGsInfo(String entId, boolean softDelete) {

        EntGsInfoEntityExample conditions = new EntGsInfoEntityExample();
        conditions.createCriteria()
                .andEntIdEqualTo(entId).andIsDeleteEqualTo(IsDeleteEnum.NO.getCode());

        if(softDelete) {
            EntGsInfoEntity newEntity = new EntGsInfoEntity();
            newEntity.setIsDelete(IsDeleteEnum.YES.getCode());
            entGsInfoEntityMapper.updateByExampleSelective(newEntity,conditions);
        }else{
            entGsInfoEntityMapper.deleteByExample(conditions);
        }

    }

}
