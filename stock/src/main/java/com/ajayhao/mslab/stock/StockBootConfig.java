package com.ajayhao.mslab.stock;

import com.ajayhao.mslab.stock.config.BaseConfig;
import org.springframework.context.annotation.*;

/**
 * Created by AjayHao on 2018/2/17.
 */
@Configuration
@ImportResource("/spring/spring-persistence.xml")
@Import(BaseConfig.class)
public class StockBootConfig {

}
