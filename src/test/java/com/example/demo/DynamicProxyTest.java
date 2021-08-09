package com.example.demo;

import com.demo.Application;
import com.demo.proxy.jdk.JDKDynamicProxy;
import com.demo.proxy.jdk.RealSubject;
import com.demo.proxy.jdk.Subject;
import com.demo.proxy.jdk.Subject1;
import com.demo.service.NewService;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class DynamicProxyTest {

    @org.junit.jupiter.api.Test
    void test(){
        Subject proxy = new JDKDynamicProxy(new RealSubject()).getProxy();
        proxy.pr();
        Subject1 proxy1 = (Subject1) proxy;
        proxy1.pr1();
    }
}
