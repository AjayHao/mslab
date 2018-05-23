package com.ajayhao.mslab.antxchecker.dto.antxchecker;

import java.io.Serializable;

/**
 * Created by AjayHao on 2017/9/10.
 */
public class AntxCheckDetail implements Serializable {
    private static final long serialVersionUID = 5620104320041023513L;

    private String keyName;

    private String autoConfigPath;

    private String result;

    private Integer state;

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getAutoConfigPath() {
        return autoConfigPath;
    }

    public void setAutoConfigPath(String autoConfigPath) {
        this.autoConfigPath = autoConfigPath;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
