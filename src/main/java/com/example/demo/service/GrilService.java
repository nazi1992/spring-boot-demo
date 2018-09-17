package com.example.demo.service;

import com.example.demo.domain.Gril;
import com.example.demo.responseDate.GrilResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/9/17 0017.
 */
@Service
@Transactional
public class GrilService {
    @Autowired
    private GrilResponseData grilResponseData;
    public void addTwo(){
        Gril gril = new Gril();
        gril.setId(1);
        gril.setCupSize("A");
        gril.setAge(20);
        Gril gril1 = new Gril();
        gril1.setId(2);
        gril1.setCupSize("FFFFff");
        gril1.setAge(21);
        grilResponseData.save(gril);
        grilResponseData.save(gril1);
    }
}
