package com.ajayhao.simpleboot.service.filecrawler.scan;

import com.ajayhao.simpleboot.service.filecrawler.vo.FileInfo;
import com.ajayhao.simpleboot.service.filecrawler.exception.FileCrawlerException;

/**
 * Created by AjayHao on 2017/7/4.
 *
 * 路径扫描接口
 */
public interface Scannable {

    //进行单层遍历扫描
    void pathScan(FileInfo fileInfo) throws FileCrawlerException;
}
