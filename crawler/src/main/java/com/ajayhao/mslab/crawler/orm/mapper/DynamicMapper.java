package com.ajayhao.mslab.crawler.orm.mapper;

import java.util.List;
import java.util.Map;

public interface DynamicMapper {

    List<Map<String, Object>> dynamicQueryReturnInt(String param);
}