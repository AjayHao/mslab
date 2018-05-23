package com.ajayhao.mslab.antxchecker.controller.antxchecker;

import com.ajayhao.core.enumtype.BizCode;
import com.ajayhao.core.exception.BaseException;
import com.ajayhao.mslab.antxchecker.dto.antxchecker.AntxCheckDetail;
import com.ajayhao.mslab.antxchecker.dto.antxchecker.AntxCheckerRequest;
import com.ajayhao.mslab.antxchecker.dto.antxchecker.AntxCheckerResponse;
import com.ajayhao.mslab.antxchecker.service.antxchecker.AntxCheckerService;
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
        }catch(BaseException be){
            response.setBizCode(BizCode.FAIL);
            response.setMessage(be.getMessage());
        }
        return response;
    }

    private void checkParam(String inputPath) {
        File projectRoot =  new File(inputPath);
        if(!projectRoot.isDirectory()){
            throw new BaseException(BizCode.INVALID_PARAM, "输入的项目路径不是可用的目录");
        }
    }
}
