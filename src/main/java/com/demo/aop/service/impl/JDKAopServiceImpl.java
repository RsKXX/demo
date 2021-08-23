package com.demo.aop.service.impl;

import com.demo.aop.annotation.AopWithInAnnotation;
import com.demo.aop.service.AopService;
import org.springframework.stereotype.Service;

/**
 * @Author RuanShaoKang
 * @since 2021/8/9 11:23
 */
@Service
@AopWithInAnnotation
public class JDKAopServiceImpl implements AopService {
    @Override
    public void test( String test) {
        System.out.println(test);
    }
}
