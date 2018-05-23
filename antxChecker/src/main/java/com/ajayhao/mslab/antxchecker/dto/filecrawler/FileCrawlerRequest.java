package com.ajayhao.mslab.antxchecker.dto.filecrawler;

import java.io.Serializable;

/**
 * Created by AjayHao on 2017/7/7.
 */
public class FileCrawlerRequest implements Serializable {

    private static final long serialVersionUID = 6030286583455067726L;

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
