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

    @Override
    public ElecreditResp getEleCreditInfo(String userId, String userKey, String entId, String category){
        ElecreditResp elecreditResp = new ElecreditResp();
        elecreditResp.buildSuccess();
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",userId);
        paramMap.put("entid",entId);
        if(StringUtils.isNotBlank(category)) {
            paramMap.put("version", category);
        }
        String info = elecreditRemoteService.getEnterpriceInfo(userKey, paramMap);
        elecreditResp.setResult(info);
        return elecreditResp;
    }
}
