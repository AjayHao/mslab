package com.ajayhao.mslab.filecrawler.service.collect;

import com.ajayhao.mslab.filecrawler.service.exception.FileCrawlerException;
import com.ajayhao.mslab.filecrawler.service.vo.FileInfo;

/**
 * Created by AjayHao on 2017/7/4.
 */
public interface Collectable {

    //采集逻辑
    void collect(FileInfo fileInfo) throws FileCrawlerException;
}
