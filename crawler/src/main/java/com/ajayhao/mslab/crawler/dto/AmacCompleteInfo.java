package com.ajayhao.mslab.crawler.dto;

import com.ajayhao.mslab.core.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * AmacCompleteInfo
 *
 * @author Ajay Hao
 * @version 1.0
 * 协会管理人信息
 * @date 2018/7/18 17:40
 **/
@Setter
@Getter
public class AmacCompleteInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private AmacManagerInfo managerInfo;

    private List<AmacFundInfo> fundInfo;

    @Override
    public String toString(){
        return JsonUtil.toJson(this);
    }
}
