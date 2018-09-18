package com.example.demo.domain;

/**
 * Created by Administrator on 2018/9/18 0018.
 */
public enum Const {
    error(-1,"未知错误"),success(0,"成功");
    private int code;
    private String desc;

    Const(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
