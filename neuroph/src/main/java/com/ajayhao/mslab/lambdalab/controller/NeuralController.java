package com.ajayhao.mslab.lambdalab.controller;

import com.ajayhao.mslab.core.common.BaseResp;
import com.ajayhao.mslab.lambdalab.service.NeuralService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 * @author AjayHao
 * @date 2017/6/18
 */
@Slf4j
@Api("神经元测试")
@RestController
@RequestMapping(value = "/neural")
public class NeuralController {

    @Autowired
    private NeuralService neuralService;

    @PostMapping("/training1")
    public BaseResp training1() {
        neuralService.trainingData1();
        return BaseResp.buildSuccess();
    }

    @GetMapping("/trainXor")
    public BaseResp trainingXor(@RequestParam("hiddenLayerNum") Integer hiddenLayerNum) {
        neuralService.trainXor(hiddenLayerNum);
        return BaseResp.buildSuccess();
    }


}
