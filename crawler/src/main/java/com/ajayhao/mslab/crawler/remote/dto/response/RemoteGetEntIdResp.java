package com.ajayhao.mslab.crawler.remote.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName RemoteGetEntIdResp
 * @Description getentid 远程返回
 * @Author Ajay Hao
 * @Date 2018/6/29 14:38
 * @Version 1.0
 **/
@Setter
@Getter
public class RemoteGetEntIdResp implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer success;

    private String code;

    private String data;

}
