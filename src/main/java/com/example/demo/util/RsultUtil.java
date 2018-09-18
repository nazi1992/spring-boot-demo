package com.example.demo.util;

import com.example.demo.domain.Const;
import com.example.demo.domain.Result;

/**
 * Created by Administrator on 2018/9/18 0018.
 */
public class RsultUtil {
    public static Result getErrorResult(String desc,int code){
        Result result = new Result();
        result.setCode(code);
        result.setDesc(desc);
        result.setData(null);
        return result;
    }
    public static Result getSuccessResult(Object object,String desc){
        Result result = new Result();
        result.setCode(Const.success.getCode());
        result.setDesc(desc);
        result.setData(object);
        return result;

    }
}
