package com.ajayhao.simpleboot.dto.antxchecker;

import java.io.Serializable;

/**
 * Created by AjayHao on 2017/9/9.
 */
public class AntxCheckerRequest implements Serializable {

    private static final long serialVersionUID = -5480041919101150447L;

    private String antxProperties;

    private String inputPath;

    public String getAntxProperties() {
        return antxProperties;
    }

    public void setAntxProperties(String antxProperties) {
        this.antxProperties = antxProperties;
    }

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }
}

