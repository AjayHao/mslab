package com.ajayhao.mslab.proxy.support.contract;

import feign.MethodMetadata;
import org.springframework.cloud.openfeign.AnnotatedParameterProcessor;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static feign.Util.emptyToNull;
import static org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation;

/**
 * ProxyContract
 * 配置代理时，动态处理内部访问路径
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2018/8/30 10:51
 */
public class ProxyContract extends SpringMvcContract {

    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    /*
    public ProxyContract() {
        super(Collections.emptyList());
    }

    public ProxyContract(
            List<AnnotatedParameterProcessor> annotatedParameterProcessors) {
        super(annotatedParameterProcessors, new DefaultConversionService());
    }
    */

    public ProxyContract(
            List<AnnotatedParameterProcessor> annotatedParameterProcessors,
            ConversionService conversionService) {
        super(annotatedParameterProcessors, conversionService);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    protected void processAnnotationOnClass(MethodMetadata data, Class<?> clz) {
        if (clz.getInterfaces().length == 0) {
            RequestMapping classAnnotation = findMergedAnnotation(clz,
                    RequestMapping.class);
            if (classAnnotation != null) {
                // Prepend path from class annotation if specified
                if (classAnnotation.value().length > 0) {
                    String pathValue = emptyToNull(classAnnotation.value()[0]);
                    pathValue = resolve(pathValue);
                    if (!pathValue.startsWith("/")) {
                        pathValue = "/" + pathValue;
                    }
                    data.template().insert(0, pathValue);
                }
            }
        }
    }

    private String resolve(String value) {
        if (StringUtils.hasText(value)
                && resourceLoader instanceof ConfigurableApplicationContext) {
            return ((ConfigurableApplicationContext) this.resourceLoader).getEnvironment()
                    .resolvePlaceholders(value);
        }
        return value;
    }
}
