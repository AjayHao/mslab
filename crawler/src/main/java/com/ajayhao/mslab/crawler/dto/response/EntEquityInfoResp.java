package com.ajayhao.mslab.crawler.dto.response;

import com.ajayhao.mslab.core.common.BaseResp;
import com.ajayhao.mslab.crawler.dto.EntEquityInfo;
import com.ajayhao.mslab.crawler.dto.EntGsInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName EntGsInfoResp
 * @Description 企业股权信息返回
 * @Author Ajay Hao
 * @Date 2018/6/21 16:58
 * @Version 1.0
 **/
@Setter
@Getter
public class EntEquityInfoResp extends BaseResp {

    /* 企业股权信息 */
    private EntEquityInfo result;
}
