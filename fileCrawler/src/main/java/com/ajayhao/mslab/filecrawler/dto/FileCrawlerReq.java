package com.ajayhao.mslab.filecrawler.dto;

import java.io.Serializable;

/**
 * Created by AjayHao on 2017/7/7.
 */
public class FileCrawlerReq implements Serializable{

    private static final long serialVersionUID = 1L;

    private String inputPath;
    private String taskId;

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
