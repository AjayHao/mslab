package com.ajayhao.mslab.crawler.service.impl;

import com.ajayhao.mslab.crawler.dto.ElecreditResp;
import com.ajayhao.mslab.crawler.remote.ElecreditRemoteService;
import com.ajayhao.mslab.crawler.service.CrawlerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
}
