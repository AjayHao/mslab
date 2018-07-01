package com.ajayhao.mslab.crawler.orm.entity;

import com.ajayhao.mslab.core.orm.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseEntDataEntity extends BaseEntity{

    protected String entId;

    protected String entName;

    protected String pullDate;

    protected String uniqueToken;

}
