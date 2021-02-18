package com.ajayhao.mslab.crawler.controller;

import com.ajayhao.mslab.core.common.BaseResp;
import com.ajayhao.mslab.crawler.orm.mapper.DynamicMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @ClassName DynamicController
 * @Description mybatis动态查询
 * @Author Ajay Hao
 * @Date 2020/4/25 17:42
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping(value = "/dynamic")
public class DynamicController {

    @Autowired
    private DynamicMapper dynamicMapper;

    @RequestMapping(value = "/retInt", method = GET)
    public BaseResp<BigDecimal> dynamicQueryReturnInt() {
        String param = "SELECT SUM(dep_prop) as deptNum FROM gtja_ft_dept_info WHERE dep_code = '10001528'";
        List<Map<String, Object>> resultList = dynamicMapper.dynamicQueryReturnInt(param);
        BaseResp<BigDecimal> baseResp = BaseResp.buildSuccess();
        if(!CollectionUtils.isEmpty(resultList)) {
            Map<String, Object> result = resultList.get(0);
            baseResp.setData((BigDecimal)result.get("deptNum".toUpperCase()));
        }

        return baseResp;
    }


    @RequestMapping(value = "/random", method = GET)
    public BaseResp<String> random() {
        return BaseResp.buildSuccess("Random integer value from Crawler:" + RandomUtils.nextInt());
    }

}
