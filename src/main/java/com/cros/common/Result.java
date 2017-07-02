package com.cros.common;

/**
 * Created by xuxiaobao on 2017/7/1.
 */
public class Result {
    private int code;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void set(int code, String data) {
        this.code = code;
        this.data = data;
    }
}
