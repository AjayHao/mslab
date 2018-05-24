package com.ajayhao.mslab.core.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isEmpty;


/**
 * <P>利用jackson的json工具类<P>
 * @author AjayHao
 * @version $Id: JsonUtil.java, v 0.1 2017年12月13日 下午8:26:14 AjayHao Exp $
 */
@UtilityClass
public final class JsonUtil {

    private static final Logger LOGGER         = LoggerFactory.getLogger(JsonUtil.class);

    /** Map  TypeReference**/
    public static final TypeReference<Map<String, String>> TYPE_REFERENCE = new TypeReference<Map<String, String>>() {
                                                                          };

    private static ObjectMapper objectMapper   = JsonObjectMapperFactory.getInstance();

    /**
     * 将对象转换为JSON字符串
     * @param obj
     * @return
     */
    public static String toJson(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            LOGGER.error("json序列化异常", e);
            throw new IllegalArgumentException("转换为JSON字符串时异常", e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> toMap(String value) {
        return parse(value, new HashMap<K, V>().getClass());
    }

    @SuppressWarnings("unchecked")
    public static <V> List<V> toList(String value) {
        return parse(value, new ArrayList<V>().getClass());
    }

    /**
     * 将JSON字符串转换为对象
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T parse(final String json, final Class<T> clazz) {
        if (isEmpty(json))
            return null;
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            LOGGER.error("json反序列化异常", e);
            throw new IllegalArgumentException("由JSON字符串时转换为对象时异常", e);
        }
    }

    /**
     * 将JSON字符串转换为对象
     * @param json
     * @param type
     * @return
     */
    public static <T> T parse(final String json, final Type type) {
        if (isEmpty(json))
            return null;
        try {
            return objectMapper.readValue(json, TypeFactory.defaultInstance().constructType(type));
        } catch (Exception e) {
            LOGGER.error("json反序列化异常", e);
            throw new IllegalArgumentException("由JSON字符串时转换为对象时异常", e);
        }
    }

    /**
     * 将JSON字符串转换为Map
     * @param json
     * @return
     */
    public static Map<String, String> parse(final String json) {
        try {
            return parse(json, TYPE_REFERENCE);
        } catch (Exception e) {
            LOGGER.error("json反序列化异常", e);
            throw new IllegalArgumentException("由JSON字符串时转换为对象时异常", e);
        }
    }

    /**
     * 将JSON字符串转换为对象
     * @param json
     * @param valueTypeRef
     * @return
     */
    public static <T> T parse(final String json, final TypeReference<T> valueTypeRef) {
        if (isEmpty(json))
            return null;
        try {
            return objectMapper.readValue(json, valueTypeRef);
        } catch (Exception e) {
            LOGGER.error("json反序列化异常", e);
            throw new IllegalArgumentException("由JSON字符串时转换为对象时异常", e);
        }
    }

    /**
     * 将JSON字符串转换为对象
     * @param json
     * @param javaType
     * @return
     */
    public static <T> T parse(final String json, final JavaType javaType) {
        if (isEmpty(json))
            return null;
        try {
            return objectMapper.readValue(json, javaType);
        } catch (Exception e) {
            LOGGER.error("json反序列化异常", e);
            throw new IllegalArgumentException("由JSON字符串时转换为对象时异常", e);
        }
    }

    /**
     * <P>json对象映射工厂<P>
     * @author AjayHao
     * @version $Id: JsonUtil.java, v 0.1 2017年12月13日 下午8:27:21 AjayHao Exp $
     */
    public static class JsonObjectMapperFactory {
        private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        private static ObjectMapper om          = new ObjectMapper();

        static {
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            om.setDateFormat(new SimpleDateFormat(DATE_FORMAT));
            om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        }

        public static ObjectMapper getInstance() {
            return om;
        }
    }

}
