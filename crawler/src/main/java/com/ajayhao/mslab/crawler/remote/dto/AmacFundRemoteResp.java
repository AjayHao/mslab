package com.ajayhao.mslab.crawler.remote.dto;

import com.ajayhao.mslab.crawler.dto.AmacFundInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 *  AmacFundRemoteResp
 *
 * 协会基金信息远程调用返回
 * @author Ajay Hao
 * @date 2018/7/30 1:22
 * @version 1.0
 **/
@Setter
@Getter
public class AmacFundRemoteResp implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<AmacFundInfo> content;

    private Integer totalPages;

    private Integer totalElements;
}
