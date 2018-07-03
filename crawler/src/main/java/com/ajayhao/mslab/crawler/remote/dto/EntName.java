package com.ajayhao.mslab.crawler.remote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName EntName
 * @Description EntName
 * @Author Ajay Hao
 * @Date 2018/7/2 10:38
 * @Version 1.0
 **/
@Setter
@Getter
@ToString
public class EntName implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "ENTNAME")
    private String entName;

}
