package com.ajayhao.mslab.crawler.repository;

import com.ajayhao.mslab.core.orm.BaseEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

import static com.ajayhao.mslab.crawler.constant.CrawlerConstants.DEFAULT_OPERATOR;

/**
 * @ClassName EntGsInfoRepositoryImpl
 * @Description 工商信息dal逻辑实现
 * @Author Ajay Hao
 * @Date 2018/6/29 11:23
 * @Version 1.0
 **/

public abstract class AbstractRepository{

    /**
     * @Description 补充isDelete
     * @Param baseEntity 补充isDelete
     * @return void
     **/
    public void prepareInsert(final BaseEntity baseEntity) {
        //填入isDelete
        if(StringUtils.isBlank(baseEntity.getIsDelete())){
            baseEntity.setIsDelete("N");
        }

        if(StringUtils.isBlank(baseEntity.getCreator())){
            baseEntity.setCreator(DEFAULT_OPERATOR);
        }

        if(StringUtils.isBlank(baseEntity.getUpdater())){
            baseEntity.setUpdater(DEFAULT_OPERATOR);
        }

        if(baseEntity.getCreatedAt() ==  null){
            baseEntity.setCreatedAt(System.currentTimeMillis());
        }

        if(baseEntity.getUpdatedAt() ==  null){
            baseEntity.setUpdatedAt(System.currentTimeMillis());
        }

    }

}
