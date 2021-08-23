package com.example.demo;

import com.demo.Application;
import com.demo.aop.service.AopService;
import com.demo.aop.service.NewService;
import com.demo.aop.service.impl.CglibAopServiceImpl;
import org.junit.jupiter.api.Test;
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

    @Test
    void test(){
        cglibAopService.test("cglib");
//        cglibAopService.test1("test1");
        System.out.println("--------引入--------");
        NewService newService = (NewService) cglibAopService;
        newService.pr();
        System.out.println("-------------------");
        aopService.test("aop");
    }


}
