package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/9/17 0017.
 */
@Aspect
@Component
public class HttpAspect {
    private Logger logger = LoggerFactory.getLogger(HttpAspect.class);//springboot自带的slfj

    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    public void log() {

    }

    //在所有控制器调用方法之前
    @Before("log()")
    public void log1(JoinPoint joinPoint) {
        //url
        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类名和类方法
        logger.info("methodClass={},={}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    //获取方法的返回参数
    @AfterReturning(returning = "object",pointcut = "log()")
    public void afterMethod1(Object object) {//注意，此处的Object,一定要为lang 内的Object,而不是其他包里的object
        System.out.println("-----return----------");
        logger.info("returnObj = {}",object);
    }
    //在所有控制器调用方法之前
    @After("log()")//基本方法，扫描的类一致，简写，去掉重复代码
    public void log2() {
        logger.info("-----after------");
    }


}
