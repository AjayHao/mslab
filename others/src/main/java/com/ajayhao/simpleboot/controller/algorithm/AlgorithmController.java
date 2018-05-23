package com.ajayhao.simpleboot.controller.algorithm;

import com.ajayhao.core.dto.BaseDTO;
import com.ajayhao.simpleboot.model.algorithm.vo.SinglyLinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by AjayHao on 2017/7/4.
 */
@RestController
public class AlgorithmController {

    @Autowired
    @Qualifier("sampleArr")
    private String[] algoSample;

    @Value("${spring.freemarker.content-type}")
    private String freemarkerContentType;

    @RequestMapping("/algo")
    public String print(){
        return BaseDTO.toString(algoSample) + freemarkerContentType;
    }

}
