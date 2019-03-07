package com.ajayhao.mslab.crawler.remote.dto;

import com.ajayhao.mslab.crawler.dto.AmacManagerInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 *  AmacManagerRemoteResp
 *
 * 协会管理人信息远程调用返回
 * @author Ajay Hao
 * @date 2018/7/20 1:22
 * @version 1.0
 **/
@Setter
@Getter
public class AmacManagerRemoteResp implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<AmacManagerInfo> content;

    private Integer totalPages;

    private Integer totalElements;
}
