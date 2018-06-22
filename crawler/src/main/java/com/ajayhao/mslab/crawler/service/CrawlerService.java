package com.ajayhao.mslab.crawler.service;

import com.ajayhao.mslab.crawler.dto.ElecreditResp;

/**
 * @ClassName CrawlerService
 * @Description 爬虫服务
 * @Author Ajay Hao
 * @Date 2018/6/6 17:45
 * @Version 1.0
 **/
public interface CrawlerService {

    ElecreditResp crawlEleCreditInfo(String entId, String category);
}
