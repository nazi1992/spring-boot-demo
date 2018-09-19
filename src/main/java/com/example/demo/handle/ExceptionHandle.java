package com.example.demo.handle;

import com.example.demo.GrilException;
import com.example.demo.domain.Result;
import com.example.demo.util.RsultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/9/18 0018.
 */
@ControllerAdvice//全局异常处理
public class ExceptionHandle {
    public static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(Exception.class)//标注要捕获的异常类型
    @ResponseBody
    public Result Handle(Exception e){
        if(e instanceof GrilException)
        {
            return RsultUtil.getErrorResult(((GrilException) e).getDesc(),((GrilException) e).getCode());
        }
        else
        {
            logger.error("系统错误-={}",e);//打印异常日志
            return RsultUtil.getErrorResult(e.getMessage(),-1);

        }
    }
}
