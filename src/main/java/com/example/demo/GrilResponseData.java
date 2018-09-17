package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/9/13 0013.
 */

public  interface GrilResponseData extends JpaRepository<Gril,Integer> {
    //通过年龄查询
    public List<Gril> findByAge(Integer age);

}
