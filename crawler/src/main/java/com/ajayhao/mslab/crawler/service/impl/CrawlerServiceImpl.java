package com.ajayhao.mslab.crawler.service.impl;

import com.ajayhao.mslab.core.util.DateUtil;
import com.ajayhao.mslab.crawler.dto.EntEquityDetailInfo;
import com.ajayhao.mslab.crawler.dto.EntEquityInfo;
import com.ajayhao.mslab.crawler.dto.EntGsInfo;
import com.ajayhao.mslab.crawler.dto.EntInvestChainInfo;
import com.ajayhao.mslab.crawler.dto.response.ElecreditResp;
import com.ajayhao.mslab.crawler.dto.response.EntEquityInfoResp;
import com.ajayhao.mslab.crawler.dto.response.EntGsInfoResp;
import com.ajayhao.mslab.crawler.enums.GsInfoQryType;
import com.ajayhao.mslab.crawler.orm.entity.*;
import com.ajayhao.mslab.crawler.orm.mapper.ManagerInfoEntityMapper;
import com.ajayhao.mslab.crawler.remote.ElecreditRemoteService;
import com.ajayhao.mslab.crawler.remote.enums.CreditQryType;
import com.ajayhao.mslab.crawler.remote.enums.ElsaicQryVersion;
import com.ajayhao.mslab.crawler.repository.EntEquityInfoRepository;
import com.ajayhao.mslab.crawler.repository.EntGsInfoRepository;
import com.ajayhao.mslab.crawler.service.CrawlerService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CrawlerServiceImpl
 * @Description 爬虫服务
 * @Author Ajay Hao
 * @Date 2018/6/6 17:47
 * @Version 1.0
 **/

@Service
public class CrawlerServiceImpl implements CrawlerService{

    @Autowired
    private EntGsInfoRepository entGsInfoRepository;

    @Autowired
    private EntEquityInfoRepository entEquityInfoRepository;

    @Autowired
    private ManagerInfoEntityMapper managerInfoEntityMapper;

    @Autowired
    private ElecreditRemoteService elecreditRemoteService;

    private final BeanCopier basicEntityCopier = BeanCopier.create(EntGsInfo.class, EntGsInfoEntity.class, false);
    private final BeanCopier basicEntityReverseCopier = BeanCopier.create(EntGsInfoEntity.class, EntGsInfo.class, false);
    private final BeanCopier investChainEntityCopier = BeanCopier.create(EntInvestChainInfo.class, EntInvestChainEntity.class, false);
    private final BeanCopier investChainEntityReverseCopier = BeanCopier.create(EntInvestChainEntity.class, EntInvestChainInfo.class, false);
    private final BeanCopier equityDetailEntityCopier = BeanCopier.create(EntEquityDetailInfo.class, EntEquityDetailEntity.class, false);
    private final BeanCopier equityDetailEntityReverseCopier = BeanCopier.create(EntEquityDetailEntity.class, EntEquityDetailInfo.class, false);


    /**
     * @Description 查询工商信息
     * @Param key 查询条件
     * @Param type  "1"-entId "2"-企业全名
     * @return EntGsInfoResp
     **/
    @Override
    public EntGsInfoResp queryGsBaseInfo(String key, GsInfoQryType type){
        EntGsInfoResp entGsInfoResp = new EntGsInfoResp().buildSuccess();
        String entId = getEntIdByKey(key, type);
        //local查询
        final EntGsInfoEntity oldEntGsInfoEntity = entGsInfoRepository.queryGsInfoByEntId(entId);
        EntGsInfo entGsInfo = null;
        //数据失效则重新加载
        if(isDataExpired(oldEntGsInfoEntity)){
            //作废老数据，重新拉取入库
            entGsInfoRepository.deleteEntGsInfo(entId, true);
            entGsInfo = elecreditRemoteService.pullEleCreditInfo(entId, ElsaicQryVersion.BASIC.getCode());
            if(entGsInfo != null){
                EntGsInfoEntity newBasicEntity = new EntGsInfoEntity();
                basicEntityCopier.copy(entGsInfo,newBasicEntity,null);
                entGsInfoRepository.insertNewGsInfo(newBasicEntity);
            }
        }else{
            entGsInfo = new EntGsInfo();
            basicEntityReverseCopier.copy(oldEntGsInfoEntity,entGsInfo,null);
        }

        entGsInfoResp.setResult(entGsInfo);
        return entGsInfoResp;
    }

    private String getEntIdByKey(String key, GsInfoQryType type) {
        String entId;
        if(type == GsInfoQryType.BY_ID){
            entId = key;
        }else{
            //获取entId
            entId = elecreditRemoteService.pullEntId(key, CreditQryType.ENT_NAME.getCode());
        }
        return entId;
    }

    //数据失效规则 有效期一周
    private boolean isDataExpired(final BaseEntDataEntity entDataEntity) {
        return (entDataEntity == null || StringUtils.isEmpty(entDataEntity.getPullDate()) ||
                DateUtil.getDays(new Date(), DateUtil.parseDateByYYYY_MM_DD(entDataEntity.getPullDate())) > 6);
    }


    /**
     * @Description 查询公司股权结构
     * @Param key 查询条件
     * @Param type  "1"-entId "2"-企业全名
     * @return
     **/
    @Override
    public EntEquityInfoResp queryEquityInfo(String key, GsInfoQryType type) {
        EntEquityInfoResp equityInfoResp = new EntEquityInfoResp().buildSuccess();
        String entId = getEntIdByKey(key, type);
        //local查询
        final EntInvestChainEntity oldInvestChainEntity = entEquityInfoRepository.queryInvestChainByEntId(entId);
        EntEquityInfo equityInfo = null;

        //数据失效则重新加载
        if(isDataExpired(oldInvestChainEntity)){
            //作废老数据，重新拉取入库
            entEquityInfoRepository.deleteEntInvestChain(entId, true);
            entEquityInfoRepository.deleteEntEquityDetail(entId, true);
            equityInfo = elecreditRemoteService.pullEquityInfo(entId);
            if(equityInfo != null){
                refreshEquityInfo(equityInfo);
            }
        }else{
            final List<EntEquityDetailEntity> oldEquityDetailEntityList = entEquityInfoRepository.queryEquityDetailEntity(key);
            equityInfo = resolveEquityInfo(oldInvestChainEntity, oldEquityDetailEntityList);
        }
        equityInfoResp.setResult(equityInfo);
        return equityInfoResp;
    }

    private EntEquityInfo resolveEquityInfo(EntInvestChainEntity oldInvestChainEntity, List<EntEquityDetailEntity> oldEquityDetailEntityList) {
        return null;
    }

    private void refreshEquityInfo(EntEquityInfo equityInfo) {
        EntInvestChainInfo investChainInfo = equityInfo.getInvestChainInfo();
        if(investChainInfo != null){

            EntInvestChainEntity entInvestChainEntity = new EntInvestChainEntity();
            investChainEntityCopier.copy(investChainInfo, entInvestChainEntity, null);
            entEquityInfoRepository.insertNewInvestChainInfo(entInvestChainEntity);
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
     * @Description 爬取企业征信信息
     * @Param [entId, category]
     * @return java.lang.String
     **/
    @Override
    public EntGsInfoResp crawlEleCreditInfo(String entId, String category){
        EntGsInfoResp entGsInfoResp = new EntGsInfoResp();
        entGsInfoResp.buildSuccess();
        EntGsInfo entGsInfo = elecreditRemoteService.pullEleCreditInfo(entId, ElsaicQryVersion.BASIC.getCode());
        if(entGsInfo != null){
            EntGsInfoEntity newBasicEntity = new EntGsInfoEntity();
            basicEntityCopier.copy(entGsInfo,newBasicEntity,null);
        }
        entGsInfoResp.setResult(entGsInfo);
        return entGsInfoResp;
    }

    /**
     * @Description 获取企业信息entId
     * @Param [key, type]
     * @return java.lang.String
     **/
    @Override
    public ElecreditResp pullEntId(String key, String type){
        ElecreditResp elecreditResp = new ElecreditResp();
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
    public ElecreditResp pullCompanyFullName(String key) {
        ElecreditResp elecreditResp = new ElecreditResp();
        elecreditResp.buildSuccess();
        String info = elecreditRemoteService.pullCompanyFullName(key);
        elecreditResp.setResult(info);
        return elecreditResp;
    }

    /**
     * @Description 根据工商企业号取企业全称
     * @Param key 工商企业号
     * @return java.lang.String
     **/
    @Override
    public ElecreditResp crawlCompanyNameByCreditCode(String key) {
        ElecreditResp elecreditResp = new ElecreditResp();
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
    public ElecreditResp crawlPublicVoices(String companyId, String begin, String end) {
        ElecreditResp elecreditResp = new ElecreditResp();
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
    public ElecreditResp crawlEntityInvestChain(String companyId, String version) {
        ElecreditResp elecreditResp = new ElecreditResp();
        elecreditResp.buildSuccess();
        String info = elecreditRemoteService.pullEntityInvestChain(companyId, version);
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
    public ElecreditResp syncAll() {
        ElecreditResp elecreditResp = new ElecreditResp();
        elecreditResp.buildSuccess();
        ManagerInfoEntityExample example = new ManagerInfoEntityExample();
        example.setOrderByClause("khdm");
        List<ManagerInfoEntity> lists = managerInfoEntityMapper.selectByExample(example);
        for(ManagerInfoEntity manager : lists){
            queryEquityInfo(manager.getGlrmc(),GsInfoQryType.BY_NAME);
        }
        elecreditResp.setResult(lists.size()+"");
        return elecreditResp;
    }
}
