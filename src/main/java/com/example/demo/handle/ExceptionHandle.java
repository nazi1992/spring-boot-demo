package com.example.demo.handle;

import com.example.demo.GrilException;
import com.example.demo.domain.Result;
import com.example.demo.util.RsultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/9/18 0018.
 */
@ControllerAdvice//全局异常处理
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)//标注要捕获的异常类型
    @ResponseBody
    public Result Handle(Exception e){
        if(e instanceof GrilException)
        {
            return RsultUtil.getErrorResult(((GrilException) e).getDesc(),((GrilException) e).getCode());
        }
        else
        {
            return RsultUtil.getErrorResult(e.getMessage(),-1);

        }
    }
}
