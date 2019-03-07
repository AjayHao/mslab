package com.ajayhao.mslab.crawler.service.impl;

import com.ajayhao.mslab.core.util.DateUtil;
import com.ajayhao.mslab.crawler.dto.EntEquityDetailInfo;
import com.ajayhao.mslab.crawler.dto.EntEquityInfo;
import com.ajayhao.mslab.crawler.dto.EntGsInfo;
import com.ajayhao.mslab.crawler.dto.response.EntCommonResp;
import com.ajayhao.mslab.crawler.dto.response.EntEquityDetailResp;
import com.ajayhao.mslab.crawler.dto.response.EntEquityFullResp;
import com.ajayhao.mslab.crawler.dto.response.EntGsInfoResp;
import com.ajayhao.mslab.crawler.enums.EntParamType;
import com.ajayhao.mslab.crawler.orm.entity.BaseEntDataEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntControlEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntEquityDetailEntity;
import com.ajayhao.mslab.crawler.orm.entity.EntGsInfoEntity;
import com.ajayhao.mslab.crawler.remote.ElecreditRemoteService;
import com.ajayhao.mslab.crawler.remote.enums.ElsaicQryVersion;
import com.ajayhao.mslab.crawler.repository.EntEquityInfoRepository;
import com.ajayhao.mslab.crawler.repository.EntGsInfoRepository;
import com.ajayhao.mslab.crawler.service.EntCreditService;
import com.ajayhao.mslab.crawler.service.plugins.EntBaseInfoService;
import com.ajayhao.mslab.crawler.service.plugins.EntEquityInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName EntCreditServiceImpl
 * @Description 企业征信服务
 * @Author Ajay Hao
 * @Date 2018/6/6 17:47
 * @Version 1.0
 **/

@Service
public class EntCreditServiceImpl implements EntCreditService {

    @Autowired
    private EntBaseInfoService entBaseInfoService;

    @Autowired
    private EntGsInfoRepository entGsInfoRepository;

    @Autowired
    private EntEquityInfoRepository entEquityInfoRepository;

    @Autowired
    private EntEquityInfoService entEquityInfoService;

    @Autowired
    private ElecreditRemoteService elecreditRemoteService;


    /**
     * @Description 查询工商信息
     * @Param key 查询条件
     * @Param type  "1"-entId "2"-企业全名
     * @return EntGsInfoResp
     **/
    @Override
    public EntGsInfoResp queryGsBaseInfo(EntParamType type, String key){
        EntGsInfoResp entGsInfoResp = new EntGsInfoResp().buildSuccess();
        String entId = entBaseInfoService.getEntIdByKey(type, key);
        //local查询
        final EntGsInfoEntity oldEntGsInfoEntity = entGsInfoRepository.queryGsInfoByEntId(entId);
        EntGsInfo entGsInfo = null;
        //数据失效则重新加载
        if(isDataExpired(oldEntGsInfoEntity)){
            entGsInfo = entBaseInfoService.refreshEntBaseInfo(EntParamType.BY_ENT_ID, entId);
        }else{
            entGsInfo = entBaseInfoService.resolveEntBaseInfo(oldEntGsInfoEntity);
        }
        entGsInfoResp.setResult(entGsInfo);
        return entGsInfoResp;
    }

    /**
     * @Description 查询公司股权结构
     * @Param key 查询条件
     * @Param type  "1"-entId "2"-统一社会认证编号 "3"-企业全名
     * @return
     **/
    @Override
    public EntEquityFullResp queryEquityInfo(EntParamType type, String key) {
        EntEquityFullResp equityInfoResp = new EntEquityFullResp().buildSuccess();
        String entId = entBaseInfoService.getEntIdByKey(type, key);
        //local查询
        final List<EntControlEntity> oldEntControlEntityList = entEquityInfoRepository.queryEntControlByEntId(entId);
        EntEquityInfo equityInfo = null;

        //数据失效则重新加载
        if(CollectionUtils.isEmpty(oldEntControlEntityList) || isDataExpired(oldEntControlEntityList.get(0))){
            equityInfo = entEquityInfoService.refreshEntEquityInfo(type ,key);
        }else{
            final List<EntEquityDetailEntity> oldEquityDetailEntityList = entEquityInfoRepository.queryEquityDetailEntity(key);
            equityInfo = entEquityInfoService.resolveEquityInfo(oldEntControlEntityList, oldEquityDetailEntityList);
        }
        equityInfoResp.setResult(equityInfo);
        return equityInfoResp;
    }

    /**
     * @Description 查询公司股权结构明细(父节点分层查询)
     * @Param entId 查询条件
     * @Param parentNodeId 查询条件
     * @return
     **/
    @Override
    public EntEquityDetailResp queryEquityDetailByParent(String entId, String parentNodeId) {
        EntEquityDetailResp equityDetailResp = new EntEquityDetailResp().buildSuccess();

        final List<EntEquityDetailEntity> equityDetailEntityList = entEquityInfoRepository.queryEquityDetailByParentNode(entId, parentNodeId);
        List<EntEquityDetailInfo> equityDetailList = entEquityInfoService.resolveEntEquityDetailInfo(equityDetailEntityList);
        equityDetailResp.setResult(equityDetailList);
        return equityDetailResp;
    }

    /**
     * 数据失效规则 有效期一周
     */
    private boolean isDataExpired(final BaseEntDataEntity entDataEntity) {
        return (entDataEntity == null || StringUtils.isEmpty(entDataEntity.getPullDate()) ||
                DateUtil.getDays(new Date(), DateUtil.parseDateByYYYY_MM_DD(entDataEntity.getPullDate())) > 6);
    }

    /**
     * @Description 爬取企业征信信息
     * @Param [entId, category]
     * @return java.lang.String
     **/
    @Override
    public EntCommonResp crawlEleCreditInfoRaw(String entId, String category){
        EntCommonResp elecreditResp = new EntCommonResp();
        elecreditResp.buildSuccess();
        String info = elecreditRemoteService.pullEleCreditInfoRaw(entId, category);
        elecreditResp.setResult(info);
        return elecreditResp;
    }

    /**
     * @Description 获取企业信息entId
     * @Param [key, type]
     * @return java.lang.String
     **/
    @Override
    public EntCommonResp pullEntId(String key, String type){
        EntCommonResp elecreditResp = new EntCommonResp();
        elecreditResp.buildSuccess();
        String info = elecreditRemoteService.pullEntId(key, type);
        elecreditResp.setResult(info);
        return elecreditResp;
    }

    /**
     * @Description 根据简称取企业全称
     * @Param key 公司名称关键字
     * @return java.lang.String
     **/
    @Override
    public EntCommonResp pullCompanyFullName(String key) {
        EntCommonResp elecreditResp = new EntCommonResp().buildSuccess();
        String companyName = elecreditRemoteService.pullCompanyFullName(key);
        elecreditResp.setResult(companyName);
        return elecreditResp;
    }

    /**
     * @Description 根据工商企业号取企业全称
     * @Param key 工商企业号
     * @return java.lang.String
     **/
    @Override
    public EntCommonResp crawlCompanyNameByCreditCode(String key) {
        EntCommonResp elecreditResp = new EntCommonResp();
        elecreditResp.buildSuccess();
        String info = elecreditRemoteService.pullCompanyNameByCreditCode(key);
        elecreditResp.setResult(info);
        return elecreditResp;
    }

    /**
     * @Description 查询公司新闻
     * @Param companyId 公司entId
     * @return java.lang.String
     **/
    @Override
    public EntCommonResp crawlPublicVoices(String companyId, String begin, String end) {
        EntCommonResp elecreditResp = new EntCommonResp();
        elecreditResp.buildSuccess();
        String info = elecreditRemoteService.pullPublicVoices(companyId, begin, end);
        elecreditResp.setResult(info);
        return elecreditResp;
    }

    /**
     * @Description 查询公司股权结构
     * @Param companyId 公司entId
     * @Param version 类型 1-全部展现 2-部分脱敏 3-全部脱敏
     * @return java.lang.String
     **/
    @Override
    public EntCommonResp crawlEntEquityControl(String companyId, String version) {
        EntCommonResp elecreditResp = new EntCommonResp();
        elecreditResp.buildSuccess();
        String info = elecreditRemoteService.pullEntEquityControl(companyId, version);
        elecreditResp.setResult(info);
        return elecreditResp;
    }

    /**
     * @Description 全量重刷
     * @Param companyId 公司entId
     * @Param version 类型 1-全部展现 2-部分脱敏 3-全部脱敏
     * @return java.lang.String
     **/
    /*@Override
    public EntCommonResp syncAll() {
        EntCommonResp elecreditResp = new EntCommonResp();
        elecreditResp.buildSuccess();
        ManagerInfoEntityExample example = new ManagerInfoEntityExample();
        List<ManagerInfoEntity> lists = managerInfoEntityMapper.selectByExample(example);
        for(ManagerInfoEntity manager : lists){
            try {
                queryEquityInfo(EntParamType.BY_NAME, manager.getGlrmc());
            }catch(Exception e){
                System.out.println(e);
            }
        }
        elecreditResp.setResult(lists.size()+"");
        return elecreditResp;
    }*/

}
