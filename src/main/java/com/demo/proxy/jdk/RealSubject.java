package com.demo.proxy.jdk;

public class RealSubject implements Subject,Subject1{
    @Override
    public void pr() {
        System.out.println("真实主题");
    }

    public void xx(){
        System.out.println("xxx");
    }
    private void xx1(){
        System.out.println("xxx1");
    }

    @Override
    public void pr1() {
        System.out.println("真实主题1");
    }
}
