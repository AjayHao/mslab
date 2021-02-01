package com.ajayhao.mslab.crawler.helper;

import com.ajayhao.mslab.crawler.dto.*;
import com.ajayhao.mslab.crawler.orm.entity.EntControlEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntEquityDetailEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntGsInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ajayhao.mslab.crawler.constant.CrawlerConstants.DEFAULT_MAP_SIZE;

/**
 * BeanEntityFactory
 *
 * @author Ajay Hao
 * @version 1.0
 * bean转换辅助类
 * @date 2018/7/24 19:15
 **/
@Slf4j
public class BeanEntityFactory {

    private static final BeanCopier basicEntityCopier = BeanCopier.create(EntGsInfo.class, EntGsInfoEntity.class, false);
    private static final BeanCopier basicEntityReverseCopier = BeanCopier.create(EntGsInfoEntity.class, EntGsInfo.class, false);

    private static final BeanCopier entControlEntityCopier = BeanCopier.create(EntControlInfo.class, EntControlEntity.class, false);
    private static final BeanCopier entControlEntityReverseCopier = BeanCopier.create(EntControlEntity.class, EntControlInfo.class, false);

    private static final BeanCopier equityDetailEntityCopier = BeanCopier.create(EntEquityDetailInfo.class, EntEquityDetailEntity.class, false);
    private static final BeanCopier equityDetailEntityReverseCopier = BeanCopier.create(EntEquityDetailEntity.class, EntEquityDetailInfo.class, false);


    public static EntGsInfo fromEntGsInfoEntity(EntGsInfoEntity entity) {
        EntGsInfo entGsInfo = null;
        if (entity != null) {
            entGsInfo = new EntGsInfo();
            basicEntityReverseCopier.copy(entity, entGsInfo, null);
        }
        return entGsInfo;
    }

    public static EntGsInfoEntity fromEntGsInfoBean(EntGsInfo bean) {
        EntGsInfoEntity entity = null;
        if (bean != null) {
            entity = new EntGsInfoEntity();
            basicEntityCopier.copy(bean, entity, null);
        }
        return entity;
    }

    public static EntControlInfo fromEntControlEntity(EntControlEntity entity) {
        EntControlInfo bean = null;
        if (entity != null) {
            bean = new EntControlInfo();
            entControlEntityReverseCopier.copy(entity, bean, null);
        }
        return bean;
    }

    public static EntControlEntity fromEntControlBean(EntControlInfo bean) {
        EntControlEntity entity = null;
        if (bean != null) {
            entity = new EntControlEntity();
            entControlEntityCopier.copy(bean, entity, null);
        }
        return entity;
    }

    public static EntEquityDetailInfo fromEntEquityDetailEntity(EntEquityDetailEntity entity) {
        EntEquityDetailInfo bean = null;
        if (entity != null) {
            bean = new EntEquityDetailInfo();
            equityDetailEntityReverseCopier.copy(entity, bean, null);
        }
        return bean;
    }

    public static EntEquityDetailEntity fromEntEquityDetailBean(EntEquityDetailInfo bean) {
        EntEquityDetailEntity entity = null;
        if (bean != null) {
            entity = new EntEquityDetailEntity();
            equityDetailEntityCopier.copy(bean, entity, null);
        }
        return entity;
    }

    public static List<EntEquityDetailInfo> fromEntEquityDetailInfos(List<EntEquityDetailEntity> list) {
        List<EntEquityDetailInfo> equityList = null;
        if (CollectionUtils.isNotEmpty(list)) {
            equityList = new ArrayList<>();
            for (final EntEquityDetailEntity equityDetailEntity : list) {
                EntEquityDetailInfo entEquityDetailInfo = fromEntEquityDetailEntity(equityDetailEntity);
                equityList.add(entEquityDetailInfo);
            }
        }
        return equityList;
    }

    public static List<EntEquityDetailEntity> fromEntEquityDetailEntities(List<EntEquityDetailInfo> list) {
        List<EntEquityDetailEntity> equityEntityList = null;
        if (CollectionUtils.isNotEmpty(list)) {
            equityEntityList = new ArrayList<>();
            for (final EntEquityDetailInfo equityDetailInfo : list) {
                EntEquityDetailEntity entEquityDetailEntity = fromEntEquityDetailBean(equityDetailInfo);
                equityEntityList.add(entEquityDetailEntity);
            }
        }
        return equityEntityList;
    }

    public static List<EntControlInfo> fromEntControlEntities(List<EntControlEntity> entControlEntityList) {
        List<EntControlInfo> entControlInfoList = null;
        if (CollectionUtils.isNotEmpty(entControlEntityList)) {
            entControlInfoList = new ArrayList<>();
            for (final EntControlEntity entControlEntity : entControlEntityList) {
                EntControlInfo entControlInfo = fromEntControlEntity(entControlEntity);
                entControlInfoList.add(entControlInfo);
            }
        }
        return entControlInfoList;
    }

    public static Map<String, List<EntEquityDetailInfo>> transferRelateEntEquityInfoMap(List<EntEquityDetailInfo> equityDetailInfoList) {
        Map<String, List<EntEquityDetailInfo>> nodeMap = null;
        if (CollectionUtils.isNotEmpty(equityDetailInfoList)) {
            nodeMap = new HashMap<>(DEFAULT_MAP_SIZE);
            for (final EntEquityDetailInfo equityInfo : equityDetailInfoList) {
                if (equityInfo != null && StringUtils.isNotBlank(equityInfo.getNodeName())) {
                    if (nodeMap.get(equityInfo.getNodeName()) == null) {
                        List<EntEquityDetailInfo> detailInfoList = new ArrayList<>();
                        detailInfoList.add(equityInfo);
                        nodeMap.put(equityInfo.getNodeName(), detailInfoList);
                    } else {
                        nodeMap.get(equityInfo.getNodeName()).add(equityInfo);
                    }
                }
            }
        }
        return nodeMap;
    }

    public static Map<String, EntEquityDetailInfo> transferEntEquityEntityMap(List<EntEquityDetailEntity> equityDetailEntityList) {
        Map<String, EntEquityDetailInfo> entEquityDetailInfoMap = null;
        if (CollectionUtils.isNotEmpty(equityDetailEntityList)) {
            entEquityDetailInfoMap = new HashMap<>(DEFAULT_MAP_SIZE);
            for (final EntEquityDetailEntity equityDetailEntity : equityDetailEntityList) {
                EntEquityDetailInfo entEquityDetailInfo = BeanEntityFactory.fromEntEquityDetailEntity(equityDetailEntity);
                if (entEquityDetailInfo != null) {
                    entEquityDetailInfoMap.put(entEquityDetailInfo.getNodeId(), entEquityDetailInfo);
                }
            }
        }
        return entEquityDetailInfoMap;
    }

    public static void mergeIntoAmacManagerInfo(AmacManagerInfo amacManagerDetail, AmacManagerInfo amacManagerInfo) {
        if (amacManagerDetail != null) {
            //清空id
            amacManagerInfo.setId(null);
            amacManagerInfo.setRegisterNo(amacManagerDetail.getRegisterNo());
            amacManagerInfo.setOrgNo(amacManagerDetail.getOrgNo());
            amacManagerInfo.setManagerName(amacManagerDetail.getManagerName());
            amacManagerInfo.setManagerNameEn(amacManagerDetail.getManagerNameEn());
            amacManagerInfo.setFrName(amacManagerDetail.getFrName());
            amacManagerInfo.setRegisterDate(amacManagerDetail.getRegisterDate());
            amacManagerInfo.setEstablishDate(amacManagerDetail.getEstablishDate());
            amacManagerInfo.setRegisterAddress(amacManagerDetail.getRegisterAddress());
            amacManagerInfo.setOfficeAddress(amacManagerDetail.getOfficeAddress());
            amacManagerInfo.setInvestType(amacManagerDetail.getInvestType());
            amacManagerInfo.setSubscribedCapital(amacManagerDetail.getSubscribedCapital());
            amacManagerInfo.setPaidInCapital(amacManagerDetail.getPaidInCapital());
            amacManagerInfo.setSubscribeRatio(amacManagerDetail.getSubscribeRatio());
            amacManagerInfo.setEntType(amacManagerDetail.getEntType());
            amacManagerInfo.setEmployeeNum(amacManagerDetail.getEmployeeNum());
            amacManagerInfo.setIntegrityInfo(amacManagerDetail.getIntegrityInfo());
            amacManagerInfo.setMemberFlag(amacManagerDetail.getMemberFlag());
            amacManagerInfo.setMemberType(amacManagerDetail.getMemberType());
            amacManagerInfo.setMemberDate(amacManagerDetail.getMemberDate());
            amacManagerInfo.setExecutiveInfo(amacManagerDetail.getExecutiveInfo());
            amacManagerInfo.setCreditInfo(amacManagerDetail.getCreditInfo());
        }
    }

    public static void mergeIntoAmacFundInfo(AmacFundInfo fundDetail, AmacFundInfo fundInfo) {
        if (fundDetail != null) {
            //清空id
            fundInfo.setId(null);
            fundInfo.setFundName(fundDetail.getFundName());
            fundInfo.setManagerName(fundDetail.getManagerName());
            fundInfo.setPutOnRecordDate(fundDetail.getPutOnRecordDate());
            fundInfo.setEstablishDate(fundDetail.getEstablishDate());
            fundInfo.setLatestUpdateDate(fundDetail.getLatestUpdateDate());
            fundInfo.setMandatorName(fundDetail.getMandatorName());
            fundInfo.setPutOnRecordStage(fundDetail.getPutOnRecordStage());
            fundInfo.setFundType(fundDetail.getFundType());
            fundInfo.setSpecialTips(fundDetail.getSpecialTips());
        }
    }

    public static List<EntControlInfo> fromEntControlListResult(List<Map<String, Object>> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return null;
        }

        List<EntControlInfo> entControlInfoList = new ArrayList<>();
        for (Map<String, Object> resultMap : entityList) {
            EntControlInfo entControlInfo = new EntControlInfo();
            entControlInfo.setEntId((String) resultMap.get("ENT_ID"));
            entControlInfo.setEntName((String) resultMap.get("ENT_NAME"));
            entControlInfo.setCerType((String) resultMap.get("CER_TYPE"));
            entControlInfo.setFinalEntName((String) resultMap.get("FINAL_ENT_NAME"));
            entControlInfo.setFinalRatio((BigDecimal) resultMap.get("FINAL_RATIO"));
            entControlInfo.setRatioRoad((String) resultMap.get("RATIO_ROAD"));
            entControlInfo.setCapitalChain((String) resultMap.get("CAPITAL_CHAIN"));
            entControlInfo.setFinalRegCap((BigDecimal) resultMap.get("FINAL_REG_CAP"));
            entControlInfo.setCreator((String) resultMap.get("CREATOR"));
            entControlInfo.setUpdater((String) resultMap.get("UPDATER"));
            /*TIMESTAMP createdAt = (TIMESTAMP) resultMap.get("CREATED_AT");
            TIMESTAMP updatedAt = (TIMESTAMP) resultMap.get("UPDATED_AT");
            try {
                if (createdAt != null) {
                    entControlInfo.setCreatedAt(createdAt.longValue());
                }
                if (updatedAt != null) {
                    entControlInfo.setUpdatedAt(updatedAt.longValue());
                }
            } catch (SQLException e) {
                log.warn(e.getMessage(), e);
            }*/
            entControlInfo.setIsDelete((String) resultMap.get("IS_DELETE"));
            entControlInfoList.add(entControlInfo);
        }
        return entControlInfoList;
    }
}
