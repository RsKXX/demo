package com.demo.service.impl;

import com.demo.annotation.AopAnnotation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
