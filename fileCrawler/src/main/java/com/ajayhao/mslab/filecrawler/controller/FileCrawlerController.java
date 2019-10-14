package com.ajayhao.mslab.filecrawler.controller;

import com.ajayhao.mslab.core.common.BaseResp;
import com.ajayhao.mslab.core.common.enums.RespCodeType;
import com.ajayhao.mslab.filecrawler.dto.FileCrawlerInfo;
import com.ajayhao.mslab.filecrawler.dto.FileCrawlerReq;
import com.ajayhao.mslab.filecrawler.service.manager.FileStatManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by AjayHao on 2017/7/5.
 */

@RestController
@RequestMapping("/filecrawler")
public class FileCrawlerController {

    ConcurrentHashMap<String,FileStatManager> fileStatManagerMap = new ConcurrentHashMap<String, FileStatManager>();

    @PostMapping
    public String post(@RequestBody FileCrawlerReq request) {
        if (StringUtils.isBlank(request.getTaskId())) {
            return "warning!empty task";
        }

        FileStatManager fileStatManager = fileStatManagerMap.get(request.getTaskId());
        //TODO 判断线程池状态
        if(fileStatManager == null){
            fileStatManager = new FileStatManager();
            fileStatManagerMap.putIfAbsent(request.getTaskId(), fileStatManager);
        }
        fileStatManager.execute(request.getInputPath());
        return "done!";
    }

    @GetMapping
    @RequestMapping("/tasks/{taskId}")
    public BaseResp<FileCrawlerInfo> getByTaskId(@PathVariable String taskId) {
        FileCrawlerInfo dto = null;
        BaseResp<FileCrawlerInfo> response = null;
        FileStatManager fileStatManager = fileStatManagerMap.get(taskId);
        if(fileStatManager == null){
            response = BaseResp.buildFail(RespCodeType.FAIL, "扫描任务编号:"+taskId+"不存在或已过期");
        }else{
            dto = new FileCrawlerInfo();
            response = BaseResp.buildSuccess();
            dto.setDataMapList(fileStatManager.getStatInfoList());
            response.setData(dto);
            //response.setMap(fileStatManager.getStatInfoDetailMap());
        }
        return response;
    }

    @GetMapping
    @RequestMapping("/tasks/{taskId}/ext/{ext}")
    public BaseResp<FileCrawlerInfo> get(@PathVariable String taskId, @PathVariable String ext) {
        FileCrawlerInfo dto = null;
        BaseResp<FileCrawlerInfo> response = null;
        FileStatManager fileStatManager = fileStatManagerMap.get(taskId);
        if(fileStatManager == null){
            response = BaseResp.buildFail(RespCodeType.FAIL, "扫描任务编号:"+taskId+"不存在或已过期");
        }else{
            dto = new FileCrawlerInfo();
            response = BaseResp.buildSuccess();
            dto.setDataMapList(fileStatManager.getStatInfoList());
            response.setData(dto);
        }
        return response;
    }
}
