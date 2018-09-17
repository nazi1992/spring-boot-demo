package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/9/11 0011.
 */
@RestController
public class HelloControl {
//    @Value("${server.cupSize}")
//    private String cupSize;
    @Autowired
    private GirlProperties girlProperties;
    //同时支持两个映射
    @RequestMapping(value ="/hello",method = RequestMethod.GET)
    public String hello(@RequestParam("id")  int id){
        return id+"====";
    }
}
