package com.example.demo;

/**
 * Created by Administrator on 2018/9/18 0018.
 */
public class GrilException extends  RuntimeException{
    private int code;
    private String desc;

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

    public GrilException(String message, int code) {
        super(message);
        this.code = code;
        this.desc = message;
    }
}
