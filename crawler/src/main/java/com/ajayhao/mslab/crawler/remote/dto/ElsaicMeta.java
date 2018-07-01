package com.ajayhao.mslab.crawler.remote.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName ElsaicMeta
 * @Description 工商信息元数据
 * @Author Ajay Hao
 * @Date 2018/6/29 17:41
 * @Version 1.0
 **/
@Setter
@Getter
public class ElsaicMeta implements Serializable{

    private static final long serialVersionUID = 1L;

    private String message;

    private String code;

    private String service;

}
