package com.cros.common;

/**
 * Created by xuxiaobao on 2017/7/1.
 */
public class Result {
    private int code;
    private Object data;

    public Result() {
    }

    public Result(int code, String data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Result set(int code, Object data) {
        this.code = code;
        this.data = data;
        return this;
    }
}
