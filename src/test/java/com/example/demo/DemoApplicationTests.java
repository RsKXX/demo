package com.example.demo;

import cn.hutool.core.collection.CollUtil;
import com.demo.Application;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.*;
import java.util.*;


@SpringBootTest(classes = Application.class)
class DemoApplicationTests {

    @Test
    public void test(){
        Map<String,String> map = new HashMap<>();
        System.out.println(CollUtil.isEmpty(map));
        map.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }

    @Test
    public void Proxy() {
//        Student student = new Student();
//        Class<?>[] interfaces = student.getClass().getInterfaces();
//        ClassLoader classLoader = student.getClass().getClassLoader();
//        Object o =  Proxy.newProxyInstance(classLoader, interfaces, (proxy, method, args) -> {
//            Object invoke = method.invoke(student,args);
//            return invoke;
//        });
//        Person proxy = (Person) o;
//
//        School proxy1 = (School) o;
////        System.out.println(o.toString());
//        proxy.getUsername();
//        proxy1.schoolName();

//        Object o2 = org.springframework.cglib.proxy.Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class,School.class}, (o1, method, objects) -> {
//            return null;
//        });
//        o2.schoolName();
//        o2.getUsername();


    }

}
