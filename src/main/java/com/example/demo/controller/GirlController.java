package com.example.demo.controller;

import com.example.demo.Gril;
import com.example.demo.GrilResponseData;
import com.example.demo.GrilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@RestController
public class GirlController {
    @Autowired
    private GrilResponseData grilResponseData;
    @Autowired
    private GrilService grilService;
    @RequestMapping(value="/grils",method = RequestMethod.GET)
    public List<Gril> getGrils(){
        return grilResponseData.findAll();
    }
    @PostMapping(value = "/add")//增加
    public Gril addGrils(@RequestParam("id") Integer id,
            @RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age){
        Gril gril = new Gril();
        gril.setAge(age);
        gril.setCupSize(cupSize);
        gril.setId(id);
        return grilResponseData.save(gril) ;
    }
    @PutMapping(value = "/update/{id}")//更新
    public Gril updateGrils(@PathVariable("id") Integer id,
                         @RequestParam("cupSize") String cupSize){
        Gril gril1 = new Gril();
        gril1.setCupSize(cupSize);
        gril1.setId(id);
        return grilResponseData.save(gril1) ;
    }
    @GetMapping(value = "/get/{id}")//查询根据id
    public Gril selectOne(@PathVariable("id") Integer id){

        return grilResponseData.findOne(id) ;
    }
    @DeleteMapping(value = "/delete/{id}")//查询根据id
    public void delete(@PathVariable("id") Integer id){

         grilResponseData.delete(id);

    }
    @GetMapping(value = "/getage/{age}")//查询根据id
    public List<Gril> getAge(@PathVariable("age") Integer age){

        return grilResponseData.findByAge(age);
    }
    @PostMapping(value = "/add/two")//查询根据id
    public void addTwo(){

         grilService.addTwo();
    }
}
