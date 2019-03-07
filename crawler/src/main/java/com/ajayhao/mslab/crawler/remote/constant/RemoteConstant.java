package com.ajayhao.mslab.crawler.remote.constant;

/**
 * @ClassName RemoteConstant
 * @Description 远程常量
 * @Author Ajay Hao
 * @Date 2018/7/9 21:34
 * @Version 1.0
 **/
public interface RemoteConstant {
    String ELSAIC_CODE = "code";

    String ELSAIC_META = "meta";

    String AMAC_PARAM_KEY = "keyword";

    String AMAC_CREDIT_INFO = "creditInfo";

    Integer AMAC_DEFAULT_PAGE_NO = 0;

    Integer AMAC_DEFAULT_PAGE_SIZE = 50;

    String AMAC_MANAGER_URL = "http://gs.amac.org.cn/amac-infodisc/api/pof/manager?rand=%s&page=%s&size=%s";

    String AMAC_MANAGER_DETAIL_URL = "http://gs.amac.org.cn/amac-infodisc/res/pof/manager/%s";

    String AMAC_FUND_URL = "http://gs.amac.org.cn/amac-infodisc/api/pof/fund?rand=%s&page=%s&size=%s";

    String AMAC_FUND_DETAIL_URL = "http://gs.amac.org.cn/amac-infodisc/res/pof/fund/%s";

}
