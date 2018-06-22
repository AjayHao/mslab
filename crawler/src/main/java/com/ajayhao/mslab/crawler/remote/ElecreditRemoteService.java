package com.ajayhao.mslab.crawler.remote;

import java.util.Map;

/**
 * @InterfaceName ElecreditRemoteService
 * @Description 元数企业信息
 * @Author Ajay Hao
 * @Date 2018/6/21 15:13
 * @Version 1.0
 **/
public interface ElecreditRemoteService {
    /**
    * @Description 爬取企业征信信息
    * @Param [entId, category]
    * @return java.lang.String
    **/
    String crawlEleCreditInfo(String entId, String category);
}
