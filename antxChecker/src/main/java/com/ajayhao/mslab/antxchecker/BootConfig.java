package com.ajayhao.mslab.antxchecker;

import com.ajayhao.mslab.antxchecker.config.BaseConfig;
import org.springframework.context.annotation.*;

/**
 * Created by AjayHao on 2018/2/17.
 */
@Configuration
@ImportResource("/spring/spring-persistence.xml")
@Import(BaseConfig.class)
public class BootConfig {

    @Bean("sampleArr")
    @Profile("dev")
    String[] getAlgoSample(){
        return new String[]{"1","2","3"};
    }

    @Bean("sampleArr")
    @Profile("prd")
    String[] getAlgoPrd(){
        return new String[]{"4","5","6"};
    }
}
