package com.example.demo;

import com.demo.Application;
import com.demo.proxy.cglib.CGlibDynamicProxy;
import com.demo.proxy.jdk.JDKDynamicProxy;
import com.demo.proxy.jdk.RealSubject;
import com.demo.proxy.jdk.Subject;
import com.demo.proxy.jdk.Subject1;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class DynamicProxyTest {

    @Test
    void jdk(){
        Subject proxy = new JDKDynamicProxy(new RealSubject()).getProxy();
        proxy.pr();
        Subject1 proxy1 = (Subject1) proxy;
        proxy1.pr1();
    }
    @Test
    void cglib(){
        CGlibDynamicProxy proxy = new CGlibDynamicProxy();
        RealSubject proxy1 = (RealSubject)proxy.getProxy(RealSubject.class);
        proxy1.pr1();
        proxy1.pr();
    }
}
