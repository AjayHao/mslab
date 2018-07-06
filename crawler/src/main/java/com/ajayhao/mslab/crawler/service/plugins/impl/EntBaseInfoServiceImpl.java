package com.ajayhao.mslab.crawler.service.plugins.impl;

import com.ajayhao.mslab.core.common.exception.BusinessBizException;
import com.ajayhao.mslab.crawler.dto.EntGsInfo;
import com.ajayhao.mslab.crawler.enums.EntParamType;
import com.ajayhao.mslab.crawler.orm.entity.EntGsInfoEntity;
import com.ajayhao.mslab.crawler.remote.ElecreditRemoteService;
import com.ajayhao.mslab.crawler.remote.enums.CreditQryType;
import com.ajayhao.mslab.crawler.remote.enums.ElsaicQryVersion;
import com.ajayhao.mslab.crawler.repository.EntGsInfoRepository;
import com.ajayhao.mslab.crawler.service.plugins.EntBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import static com.ajayhao.mslab.core.common.enums.RespCodeType.PARAM_ILLEGAL;

/**
 * @ClassName EntBaseInfoServiceImpl
 * @Description EntBaseInfoServiceImpl
 * @Author Ajay Hao
 * @Date 2018/7/4 17:10
 * @Version 1.0
 **/
@Service
public class EntBaseInfoServiceImpl implements EntBaseInfoService{

    private final BeanCopier basicEntityCopier = BeanCopier.create(EntGsInfo.class, EntGsInfoEntity.class, false);
    private final BeanCopier basicEntityReverseCopier = BeanCopier.create(EntGsInfoEntity.class, EntGsInfo.class, false);

    @Autowired
    private EntGsInfoRepository entGsInfoRepository;

    @Autowired
    private ElecreditRemoteService elecreditRemoteService;

    /**
     * @Description 根据关键字查entId
     * @Param key 与paramType对应的操作变量
     * @Param type 参数类型
     * @return String
     **/
    @Override
    public String getEntIdByKey(EntParamType type, String key) {
        String entId = null;
        if(type == null){
            throw new BusinessBizException(PARAM_ILLEGAL, "entParamType="+type);
        }

        if(type == EntParamType.BY_ENT_ID){
            entId = key;
        }else if(type == EntParamType.BY_CREDIT_CODE){
            //获取entId
            entId = elecreditRemoteService.pullEntId(key, CreditQryType.CREDIT_CODE.getCode());
        }else if(type == EntParamType.BY_NAME){
            //获取entId
            entId = elecreditRemoteService.pullEntId(key, CreditQryType.ENT_NAME.getCode());
        }
        return entId;
    }

    /**
     * @Description 数据同步
     * @Param paramType 操作条件
     * @Param key 与paramType对应的操作变量
     * @return EntGsInfo
     **/
    @Override
    public EntGsInfo refreshEntBaseInfo(EntParamType paramType, String key){
        String entId = getEntIdByKey(paramType, key);
        //作废老数据，重新拉取入库
        entGsInfoRepository.deleteEntGsInfo(entId, false);
        EntGsInfo entGsInfo = elecreditRemoteService.pullEleCreditInfo(entId, ElsaicQryVersion.BASIC.getCode());
        if(entGsInfo != null){
            EntGsInfoEntity newBasicEntity = new EntGsInfoEntity();
            basicEntityCopier.copy(entGsInfo,newBasicEntity,null);
            entGsInfoRepository.insertNewGsInfo(newBasicEntity);
        }
        return entGsInfo;
    }

    @Override
    public EntGsInfo resolveEntBaseInfo(EntGsInfoEntity oldEntGsInfoEntity) {
        EntGsInfo entGsInfo = new EntGsInfo();
        basicEntityReverseCopier.copy(oldEntGsInfoEntity,entGsInfo,null);
        return entGsInfo;
    }
}
