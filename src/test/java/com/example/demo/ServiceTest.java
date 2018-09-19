package com.example.demo;

import com.example.demo.service.GrilService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2018/9/19 0019.
 */

/**
 * 单元测试,对Service进行测试
 */
@RunWith(SpringRunner.class)//运行spring junit
@SpringBootTest
public class ServiceTest {

    @Autowired
    private GrilService grilService;
    @Test
    public void getAge(){//启动测试
        Assert.assertEquals(new Integer(22),grilService.getCupSize1(1));
    }
}
