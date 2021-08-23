package com.demo.aop.service.impl;

import com.demo.aop.annotation.AopAnnotation;
import org.springframework.stereotype.Service;


/**
 * @Author RuanShaoKang
 * @since 2021/7/1 15:00
 */

@Service
public class CglibAopServiceImpl {

    public String test( String test) {
        System.out.println(test);
        return test;
    }

    @AopAnnotation
    public void test1(String name){
        System.out.println(name);
    }


}
