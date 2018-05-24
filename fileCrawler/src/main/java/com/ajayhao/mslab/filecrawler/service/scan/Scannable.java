package com.ajayhao.mslab.filecrawler.service.scan;

import com.ajayhao.mslab.filecrawler.service.vo.FileInfo;
import com.ajayhao.mslab.filecrawler.service.exception.FileCrawlerException;

/**
 * Created by AjayHao on 2017/7/4.
 *
 * 路径扫描接口
 */
public interface Scannable {

    //进行单层遍历扫描
    void pathScan(FileInfo fileInfo) throws FileCrawlerException;
}
