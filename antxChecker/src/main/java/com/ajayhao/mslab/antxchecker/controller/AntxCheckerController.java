package com.ajayhao.mslab.antxchecker.controller;

import com.ajayhao.mslab.antxchecker.dto.AntxCheckDetail;
import com.ajayhao.mslab.antxchecker.dto.AntxCheckerRequest;
import com.ajayhao.mslab.antxchecker.dto.AntxCheckerResponse;
import com.ajayhao.mslab.antxchecker.service.AntxCheckerService;
import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.ajayhao.mslab.core.common.exception.BusinessBizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * Created by AjayHao on 2017/7/5.
 */

@RestController
@RequestMapping("/checkantx")
public class AntxCheckerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AntxCheckerService antxCheckerService;

    @PostMapping
    public AntxCheckerResponse post(@RequestBody AntxCheckerRequest request) {

        AntxCheckerResponse response = new AntxCheckerResponse();
        String inputPath = request.getInputPath();
        String antxProperties = request.getAntxProperties();
        try{
            checkParam(inputPath);
            List<AntxCheckDetail> detailList = antxCheckerService.checkAntx(inputPath, antxProperties);
            response.setDetails(detailList);
        }catch(BusinessBizException be){
            response.setBizCode(RespCodeType.FAIL);
            response.setMessage(be.getMessage());
        }
        return response;
    }

    private void checkParam(String inputPath) {
        File projectRoot =  new File(inputPath);
        if(!projectRoot.isDirectory()){
            throw new BusinessBizException(RespCodeType.INVALID_PARAM, "输入的项目路径不是可用的目录");
        }
    }
}
