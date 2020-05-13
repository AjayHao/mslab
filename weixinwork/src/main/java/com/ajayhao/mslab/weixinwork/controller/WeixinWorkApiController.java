package com.ajayhao.mslab.weixinwork.controller;

import com.ajayhao.mslab.weixinwork.service.WeixinWorkService;
import com.ajayhao.mslab.weixinwork.utils.weixin.aes.AesException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * WeixinWorkApiController
 * <p>
 * TODO
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2020/5/10 17:03
 */

@Slf4j
@Api("企业微信接口")
@RestController
@RequestMapping(value = "/weixin_work")
public class WeixinWorkApiController {

    @Autowired
    WeixinWorkService weixinWorkService;

    /**
     * 验证接收的回调消息
     * @param msgSignature
     * @param timestamp
     * @param nonce
     * @param echoStr
     * @return
     */
    @ApiOperation("url验证")
    @GetMapping(value = "/message_callback")
    public String verifyCallbackUrl(@RequestParam("msg_signature") String msgSignature,
                                    @RequestParam("timestamp") Long timestamp,
                                    @RequestParam("nonce") Long nonce,
                                    @RequestParam("echostr") String echoStr) {
        try {
            return weixinWorkService.verifyCallbackUrl(msgSignature, String.valueOf(timestamp), String.valueOf(nonce), echoStr);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return null;
    }


    @ApiOperation("消息接收与回复")
    @PostMapping(value = "/message_callback")
    public String sendCallbackData(@RequestParam("msg_signature") String msgSignature,
                                    @RequestParam("timestamp") Long timestamp,
                                    @RequestParam("nonce") Long nonce,
                                    @RequestBody String echoStr) {
        try {
            return weixinWorkService.handleReqMsg(msgSignature, String.valueOf(timestamp), String.valueOf(nonce), echoStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}
