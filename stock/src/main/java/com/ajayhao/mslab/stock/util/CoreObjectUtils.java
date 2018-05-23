package com.ajayhao.mslab.stock.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AjayHao on 2017/7/7.
 */
public class CoreObjectUtils {

    private static final Logger logger = LoggerFactory.getLogger(CoreObjectUtils.class);
    /**
     * 将java实例转换为json对象，按field进行转换<br/>
     *
     * @param obj
     * @return
     */
    public static String object2Json(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.configure(SerializationFeature.INDENT_OUTPUT, false);
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.warn("Object to Json error: ", e);
        }

        return null;
    }

    /**
     * 将json字符串转换为java实例，按照field进行转换<br/>
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T json2Object(String json, Class<T> clazz) {
        if (json == null || json.isEmpty()) {
            return (T) null;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            /*Module m = resolveDeserializerModule(clazz);
            mapper.registerModule(m);*/
            Object bean = mapper.readValue(json, clazz);
            return (T) bean;
        } catch (Exception e) {
            logger.warn("json to Object error: ", e);
        }

        return null;
    }
}
