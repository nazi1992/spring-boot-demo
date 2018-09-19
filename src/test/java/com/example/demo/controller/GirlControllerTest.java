package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by Administrator on 2018/9/19 0019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc//针对control的测试而需要新增的注解
public class GirlControllerTest {
    //注入该对象，可用模拟发起请求
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetGrils() throws Exception {
         //   mvc.perform(MockMvcRequestBuilders.get("/grils")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("abc"));
        //希望grils接口响应正常，且返回的数据为abc,显然后一条并不满足
    }
}