package com.ajayhao.mslab.core.orm;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BaseEntity {

    protected String id;

    protected Integer isDelete = 0;

    protected String creator;

    protected Date createdAt;

    protected String updater;

    protected Date updatedAt;

}
