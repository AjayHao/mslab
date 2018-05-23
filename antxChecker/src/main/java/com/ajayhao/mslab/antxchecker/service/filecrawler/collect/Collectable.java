package com.ajayhao.mslab.antxchecker.service.filecrawler.collect;

import com.ajayhao.mslab.antxchecker.service.filecrawler.vo.FileInfo;
import com.ajayhao.mslab.antxchecker.service.filecrawler.exception.FileCrawlerException;

/**
 * Created by AjayHao on 2017/7/4.
 */
public interface Collectable {

    //采集逻辑
    void collect(FileInfo fileInfo) throws FileCrawlerException;
}
