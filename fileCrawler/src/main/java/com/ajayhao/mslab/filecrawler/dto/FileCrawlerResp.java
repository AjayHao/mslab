package com.ajayhao.mslab.filecrawler.dto;

import com.ajayhao.mslab.core.common.BaseResp;
import com.ajayhao.mslab.core.common.enums.RespCodeType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Created by AjayHao on 2017/7/7.
 */

@Setter
@Getter
public class FileCrawlerResp extends BaseResp {
    private List<Map> dataMapList;

    private List<Map> detailList;

    public FileCrawlerResp(RespCodeType bizCode, String message){
        of(bizCode.getCode(), message);
    }
}
