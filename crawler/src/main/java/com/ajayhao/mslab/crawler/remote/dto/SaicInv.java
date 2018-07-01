package com.ajayhao.mslab.crawler.remote.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName SaicInv
 * @Description SaicInv
 * @Author Ajay Hao
 * @Date 2018/7/2 1:22
 * @Version 1.0
 **/
@Setter
@Getter
public class SaicInv implements Serializable{
    private static final long serialVersionUID = 1L;

    private String code;

    private List<Inv> inv;

    private InvRoad road;
}
