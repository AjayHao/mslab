package com.ajayhao.mslab.crawler.service.plugins.impl;

import com.ajayhao.mslab.crawler.dto.EntControlInfo;
import com.ajayhao.mslab.crawler.dto.EntEquityDetailInfo;
import com.ajayhao.mslab.crawler.dto.EntEquityInfo;
import com.ajayhao.mslab.crawler.enums.EntParamType;
import com.ajayhao.mslab.crawler.orm.entity.EntControlEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntEquityDetailEntity;
import com.ajayhao.mslab.crawler.remote.ElecreditRemoteService;
import com.ajayhao.mslab.crawler.repository.EntEquityInfoRepository;
import com.ajayhao.mslab.crawler.service.plugins.EntBaseInfoService;
import com.ajayhao.mslab.crawler.service.plugins.EntEquityInfoService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EntBaseInfoServiceImpl
 * @Description EntEquityInfoServiceImpl
 * @Author Ajay Hao
 * @Date 2018/7/4 17:10
 * @Version 1.0
 **/
@Service
public class EntEquityInfoServiceImpl implements EntEquityInfoService {

    @Autowired
    private EntBaseInfoService entBaseInfoService;

    @Autowired
    private EntEquityInfoRepository entEquityInfoRepository;

    @Autowired
    private ElecreditRemoteService elecreditRemoteService;

    private final BeanCopier entControlEntityCopier = BeanCopier.create(EntControlInfo.class, EntControlEntity.class, false);
    private final BeanCopier equityDetailEntityCopier = BeanCopier.create(EntEquityDetailInfo.class, EntEquityDetailEntity.class, false);

    private final BeanCopier entControlEntityReverseCopier = BeanCopier.create(EntControlEntity.class, EntControlInfo.class, false);
    private final BeanCopier equityDetailEntityReverseCopier = BeanCopier.create(EntEquityDetailEntity.class, EntEquityDetailInfo.class, false);

    /**
     * @Description 根据关键字查entId
     * @Param key 与paramType对应的操作变量
     * @Param type 参数类型
     * @return String
     **/
    private void refreshEquityInfo(EntEquityInfo equityInfo) {
        List<EntControlInfo> entControlInfoList = equityInfo.getEntControlList();
        if(CollectionUtils.isNotEmpty(entControlInfoList)){
            for(EntControlInfo entControl : entControlInfoList) {
                EntControlEntity entControlEntity = new EntControlEntity();
                entControlEntityCopier.copy(entControl, entControlEntity, null);
                entEquityInfoRepository.insertNewEntControl(entControlEntity);
            }
        }

        List<EntEquityDetailInfo> equityDetailList = equityInfo.getEquityDetailList();
        if(CollectionUtils.isNotEmpty(equityDetailList)){
            for(EntEquityDetailInfo equityDetailInfo : equityDetailList){
                EntEquityDetailEntity entEquityDetailEntity = new EntEquityDetailEntity();
                equityDetailEntityCopier.copy(equityDetailInfo, entEquityDetailEntity, null);
                entEquityInfoRepository.insertNewEquityDetail(entEquityDetailEntity);
            }
        }
    }

    /**
     * @Description 数据刷新
     * @Param paramType 操作条件
     * @Param key 与paramType对应的操作变量
     * @return EntEquityInfo
     **/
    @Override
    public EntEquityInfo refreshEntEquityInfo(EntParamType paramType, String key){
        String entId = entBaseInfoService.getEntIdByKey(paramType, key);
        //作废老数据，重新拉取入库
        entEquityInfoRepository.deleteEntControl(entId, false);
        entEquityInfoRepository.deleteEntEquityDetail(entId, false);
        EntEquityInfo equityInfo = elecreditRemoteService.pullEquityInfo(entId);
        if(equityInfo != null){
            refreshEquityInfo(equityInfo);
        }

        return equityInfo;
    }

    /**
     * @Description 解析股权信息
     * @Param oldEntControlEntity 控制人信息
     * @Param oldEquityDetailEntityList 股权详情
     * @return EntEquityInfo
     **/
    @Override
    public EntEquityInfo resolveEquityInfo(List<EntControlEntity> oldEntControlEntityList, List<EntEquityDetailEntity> oldEquityDetailEntityList) {
        EntEquityInfo entEquityInfo = new EntEquityInfo();
        List<EntControlInfo> entControlInfoList = resolveEntControlInfo(oldEntControlEntityList);
        List<EntEquityDetailInfo> entEquityDetailInfoList = resolveEntEquityDetailInfo(oldEquityDetailEntityList);
        entEquityInfo.setEquityDetailList(entEquityDetailInfoList);
        entEquityInfo.setEntControlList(entControlInfoList);
        return entEquityInfo;
    }

    private List<EntControlInfo> resolveEntControlInfo(List<EntControlEntity> oldEntControlEntityList) {
        List<EntControlInfo> entControlInfoList = null;
        if(CollectionUtils.isNotEmpty(oldEntControlEntityList)){
            entControlInfoList = new ArrayList<>();
            for(final EntControlEntity entControlEntity: oldEntControlEntityList) {
                EntControlInfo entControlInfo = new EntControlInfo();
                entControlEntityReverseCopier.copy(entControlEntity, entControlInfo, null);
                entControlInfoList.add(entControlInfo);
            }
        }
        return entControlInfoList;
    }

    /**
     * @Description 解析股权详情
     * @Param equityDetailEntityList 股权详情
     * @return List<EntEquityDetailInfo>
     **/
    @Override
    public List<EntEquityDetailInfo> resolveEntEquityDetailInfo(List<EntEquityDetailEntity> equityDetailEntityList) {
        List<EntEquityDetailInfo> entEquityDetailInfoList = null;
        if(CollectionUtils.isNotEmpty(equityDetailEntityList)){
            entEquityDetailInfoList = new ArrayList<>();
            for(final EntEquityDetailEntity equityDetailEntity: equityDetailEntityList) {
                EntEquityDetailInfo entEquityDetailInfo = new EntEquityDetailInfo();
                equityDetailEntityReverseCopier.copy(equityDetailEntity, entEquityDetailInfo, null);
                entEquityDetailInfoList.add(entEquityDetailInfo);
            }
        }
        return entEquityDetailInfoList;
    }
}
