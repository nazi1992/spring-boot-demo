package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/9/17 0017.
 */
@Aspect
@Component
public class HttpAspect {
    private Logger logger = LoggerFactory.getLogger(HttpAspect.class);//springboot自带的slfj
    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    public void log(){

    }
    //在所有控制器调用方法之前
    @Before("log()")
    public void log1(){
        logger.info("-----long------");
    }
    //在所有控制器调用方法之前
    @After("log()")//基本方法，扫描的类一致，简写，去掉重复代码
    public void log2(){
        logger.info("-----after------");
    }
}
