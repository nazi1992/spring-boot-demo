package com.example.demo.controller;

import com.example.demo.domain.Const;
import com.example.demo.domain.Gril;
import com.example.demo.domain.Result;
import com.example.demo.responseDate.GrilResponseData;
import com.example.demo.service.GrilService;
import com.example.demo.util.RsultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping(value = "/add1")//增加,表单验证，BindingResult为验证的结果
    public Result<Gril> addGrils(@Valid  Gril gril, BindingResult result){

        if(result.hasErrors())
        {
            System.out.println(result.getFieldError().getDefaultMessage());

            return RsultUtil.getErrorResult(result.getFieldError().getDefaultMessage(),Const.error.getCode());
        }

        return RsultUtil.getSuccessResult(grilResponseData.save(gril),Const.success.getDesc()) ;
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
    @GetMapping(value = "/getAge/{id}")//统一异常处理
    public void getCupSize(@PathVariable("id") Integer id){

        grilService.getCupSize(id);
    }
}
