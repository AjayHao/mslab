package com.ajayhao.mslab.crawler.dto.response;

import com.ajayhao.mslab.core.common.BaseResp;
import com.ajayhao.mslab.crawler.dto.EntEquityDetailInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName EntEquityDetailResp
 * @Description 企业股权明细信息返回
 * @Author Ajay Hao
 * @Date 2018/6/21 16:58
 * @Version 1.0
 **/
@Setter
@Getter
public class EntEquityDetailResp extends BaseResp {

    /**
    * 股权明细
    */
    private List<EntEquityDetailInfo> result;
}
