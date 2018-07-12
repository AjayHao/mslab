package com.ajayhao.mslab.core.orm;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BaseEntity {

    protected String id;

    protected String isDelete = "Y";

    protected String creator;

    protected Long createdAt;

    protected String updater;

    protected Long updatedAt;

}
