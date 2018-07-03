package com.ajayhao.mslab.crawler.remote.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName EntNameRemoteResp
 * @Description EntNameRemoteResp
 * @Author Ajay Hao
 * @Date 2018/7/2 10:39
 * @Version 1.0
 **/
@Setter
@Getter
public class EntNameRemoteResp implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private List<EntName> data;
}
