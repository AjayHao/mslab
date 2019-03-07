package com.ajayhao.mslab.crawler.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * AmacExecutiveInfo
 *
 * @author Ajay Hao
 * @version 1.0
 * 高管信息
 * @date 2018/7/30 13:55
 **/
@Setter
@Getter
public class AmacExecutiveInfo implements Serializable{
    private static final long serialVersionUID = 1L;

    private String registerNo;

    private String executiveName;

    private String position;

    private String qualification;

    private String qualifiedBy;

}
