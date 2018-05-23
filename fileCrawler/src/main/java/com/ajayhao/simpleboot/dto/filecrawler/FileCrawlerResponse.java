package com.ajayhao.simpleboot.dto.filecrawler;

import com.ajayhao.core.enumtype.BizCode;
import com.ajayhao.simpleboot.dto.CommonResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by AjayHao on 2017/7/7.
 */
public class FileCrawlerResponse extends CommonResponse {
    private List<Map> dataMapList;

    private List<Map> detailList;

    FileCrawlerResponse(){
        super();
    }

    public FileCrawlerResponse(BizCode bizCode){
        super(bizCode);
    }

    public FileCrawlerResponse(BizCode bizCode, String message){
        super(bizCode, message);
    }

    public List<Map> getDataMapList() {
        return dataMapList;
    }

    public void setDataMapList(List<Map> dataMapList) {
        this.dataMapList = dataMapList;
    }

    public List<Map> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Map> detailList) {
        this.detailList = detailList;
    }

}
