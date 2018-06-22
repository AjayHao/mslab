package com.ajayhao.mslab.crawler.service.impl;

import com.ajayhao.mslab.crawler.dto.ElecreditResp;
import com.ajayhao.mslab.crawler.remote.ElecreditRemoteService;
import com.ajayhao.mslab.crawler.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ElecreditRemoteService elecreditRemoteService;

    /**
     * @Description 爬取企业征信信息
     * @Param [entId, category]
     * @return java.lang.String
     **/
    @Override
    public ElecreditResp crawlEleCreditInfo(String entId, String category){
        ElecreditResp elecreditResp = new ElecreditResp();
        elecreditResp.buildSuccess();
        String info = elecreditRemoteService.crawlEleCreditInfo(entId, category);
        elecreditResp.setResult(info);
        return elecreditResp;
    }

    /**
     * @Description 获取企业信息entId
     * @Param [key, type]
     * @return java.lang.String
     **/
    @Override
    public ElecreditResp crawlEntId(String key, String type){
        ElecreditResp elecreditResp = new ElecreditResp();
        elecreditResp.buildSuccess();
        String info = elecreditRemoteService.crawlEntId(key, type);
        elecreditResp.setResult(info);
        return elecreditResp;
    }

    /**
     * @Description 根据简称取企业全称
     * @Param key 公司名称关键字
     * @return java.lang.String
     **/
    @Override
    public ElecreditResp crawlCompanyFullName(String key) {
        ElecreditResp elecreditResp = new ElecreditResp();
        elecreditResp.buildSuccess();
        String info = elecreditRemoteService.crawlCompanyFullName(key);
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
        String info = elecreditRemoteService.crawlCompanyNameByCreditCode(key);
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
        String info = elecreditRemoteService.crawlPublicVoices(companyId, begin, end);
        elecreditResp.setResult(info);
        return elecreditResp;
    }

}
