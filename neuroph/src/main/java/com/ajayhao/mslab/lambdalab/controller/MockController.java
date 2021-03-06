package com.ajayhao.mslab.lambdalab.controller;

import com.ajayhao.mslab.core.common.BaseResp;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 * @author AjayHao
 * @date 2017/6/18
 */
@Slf4j
@Api("配合前端Mocker")
@RestController
@RequestMapping(value = "/mock")
//@CrossOrigin(origins = "*",maxAge = 3600)
public class MockController {

    @RequestMapping(value = "/sleep/{milliSeconds}", method = GET)
    public BaseResp<String> sleep(@PathVariable Integer milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return BaseResp.buildSuccess(String.valueOf(milliSeconds));
    }

    @GetMapping("/team/")
    public BaseResp<String> queryTeam(@RequestParam String userId) {
        BaseResp<String> resp = new BaseResp<>();
        try {
            Thread.sleep(RandomUtils.nextInt(500,1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String retStr = "foo".equals(userId) ? "T001" : "T002";
        if("bar".equals(userId)){
            resp = BaseResp.buildFail();
        } else {
            resp = BaseResp.buildSuccess(retStr);
        }
        return resp;
    }

    @GetMapping("/resource/")
    public BaseResp<String> queryResourceByTeam(@RequestParam String teamId) {
        BaseResp<String> resp = new BaseResp<>();
        try {
            Thread.sleep(RandomUtils.nextInt(500,1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String retStr = "T001".equals(teamId) ? "R001" : "R002";
        resp = BaseResp.buildSuccess(retStr);
        return resp;
    }

    @GetMapping("/file/")
    public BaseResp<String> queryFileByResource(@RequestParam String resourceId) {
        BaseResp<String> resp = new BaseResp<>();
        try {
            Thread.sleep(RandomUtils.nextInt(500,1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if("R001".equals(resourceId)) {
            resp = BaseResp.buildSuccess("F001");
        }else{
            resp = BaseResp.buildFail();
        }

        return resp;

    }
}
