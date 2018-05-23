package com.ajayhao.simpleboot.controller.filecrawler;

import com.ajayhao.core.enumtype.BizCode;
import com.ajayhao.simpleboot.dto.CommonResponse;
import com.ajayhao.simpleboot.dto.filecrawler.FileCrawlerRequest;
import com.ajayhao.simpleboot.dto.filecrawler.FileCrawlerResponse;
import com.ajayhao.simpleboot.service.filecrawler.manager.FileStatManager;
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
    public String post(@RequestBody FileCrawlerRequest request) {
        if(StringUtils.isBlank(request.getTaskId())) return "fuck!empty task";

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
    public CommonResponse getByTaskId(@PathVariable String taskId) {
        FileCrawlerResponse response = null;
        FileStatManager fileStatManager = fileStatManagerMap.get(taskId);
        if(fileStatManager == null){
            response = new FileCrawlerResponse(BizCode.FAIL, "扫描任务编号:"+taskId+"不存在或已过期");
        }else{
            response = new FileCrawlerResponse(BizCode.SUCCESS, "执行成功");
            response.setDataMapList(fileStatManager.getStatInfoList());
            //response.setMap(fileStatManager.getStatInfoDetailMap());
        }
        return response;
    }

    @GetMapping
    @RequestMapping("/tasks/{taskId}/ext/{ext}")
    public CommonResponse get(@PathVariable String taskId, @PathVariable String ext) {
        FileCrawlerResponse response = null;
        FileStatManager fileStatManager = fileStatManagerMap.get(taskId);
        if(fileStatManager == null){
            response = new FileCrawlerResponse(BizCode.FAIL, "扫描任务编号:"+taskId+"不存在或已过期");
        }else{
            response = new FileCrawlerResponse(BizCode.SUCCESS, "执行成功");
            response.setDetailList(fileStatManager.getStatInfoDetailByExt(ext));
            //response.setMap(fileStatManager.getStatInfoDetailMap());
        }
        return response;
    }
}
