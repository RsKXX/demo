package com.demo.proxy.jdk;

public class RealSubject implements Subject,Subject1{
    @Override
    public void pr() {
        System.out.println("Subject");
    }
    @Override
    public void pr1() {
        System.out.println("Subject1");
    }
}
