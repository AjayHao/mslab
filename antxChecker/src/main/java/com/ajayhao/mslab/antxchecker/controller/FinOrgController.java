package com.ajayhao.mslab.antxchecker.controller;

import com.ajayhao.mslab.antxchecker.orm.entity.FinOrgEntity;
import com.ajayhao.mslab.antxchecker.orm.entity.FinOrgEntityExample;
import com.ajayhao.mslab.antxchecker.orm.mapper.FinOrgEntityMapper;
import com.ajayhao.mslab.core.common.BaseResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by AjayHao on 2017/6/18.
 */

@Api(tags = "机构查询")
@RestController
@RequestMapping("/finOrg")
public class FinOrgController {

    @Autowired
    private FinOrgEntityMapper finOrgEntityMapper;

    @ApiOperation("测试1")
    @GetMapping("/testQuery")
    public BaseResp<List<String>> testQuery() {
        FinOrgEntityExample example = new FinOrgEntityExample();
        example.createCriteria().andCreditCodeEqualTo("91100000100003962T");
        List<FinOrgEntity> orgEntities = finOrgEntityMapper.selectByExample(example);
        List<String> list = orgEntities.stream().map(FinOrgEntity::getOrgName).collect(Collectors.toList());
        return BaseResp.buildSuccess(list);
    }
}
