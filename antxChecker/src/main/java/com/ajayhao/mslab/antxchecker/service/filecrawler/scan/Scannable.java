package com.ajayhao.mslab.antxchecker.service.filecrawler.scan;

import com.ajayhao.mslab.antxchecker.service.filecrawler.exception.FileCrawlerException;
import com.ajayhao.mslab.antxchecker.service.filecrawler.vo.FileInfo;

/**
 * Created by AjayHao on 2017/7/4.
 *
 * 路径扫描接口
 */
public interface Scannable {

    //进行单层遍历扫描
    void pathScan(FileInfo fileInfo) throws FileCrawlerException;
}
