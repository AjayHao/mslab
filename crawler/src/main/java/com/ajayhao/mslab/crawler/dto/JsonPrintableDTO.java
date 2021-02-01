package com.ajayhao.mslab.crawler.dto;

import com.ajayhao.mslab.core.util.JsonUtil;

import java.io.Serializable;

/**
 * JsonPrintableDTO
 * <p>
 * 子类可自动继承json打印效果
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2018/12/4 14:26
 **/
public class JsonPrintableDTO implements Serializable {
    private static final long serialVersionUID = -5825734206488813725L;

    @Override
    public String toString(){
        return JsonUtil.toJson(this);
    }
}
