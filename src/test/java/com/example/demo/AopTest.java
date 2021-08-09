package com.example.demo;

import com.demo.Application;
import com.demo.service.AopService;
import com.demo.service.NewService;
import com.demo.service.impl.CglibAopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @Author RuanShaoKang
 * @since 2021/8/9 11:15
 */

@SpringBootTest(classes = Application.class)
class AopTest {
    @Autowired
    CglibAopServiceImpl cglibAopService;

    @Autowired
    AopService aopService;

    @org.junit.jupiter.api.Test
    void test(){
        cglibAopService.test("cglib");
        NewService newService = (NewService) cglibAopService;
        newService.pr();
//        aopService.test("aop");
    }


}
