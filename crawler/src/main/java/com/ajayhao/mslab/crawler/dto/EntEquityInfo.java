package com.ajayhao.mslab.crawler.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName EntEquityInfo
 * @Description 股权信息
 * @Author Ajay Hao
 * @Date 2018/7/1 20:18
 * @Version 1.0
 **/
@Setter
@Getter
public class EntEquityInfo implements Serializable {

    /*
    * 大股东投资链
    * */
    private List<EntControlInfo> entControlList;

    /*
    * 股权明细
    * */
    private List<EntEquityDetailInfo> equityDetailList;
}
