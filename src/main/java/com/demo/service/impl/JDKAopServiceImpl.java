package com.demo.service.impl;

import com.demo.annotation.AopWithInAnnotation;
import com.demo.service.AopService;
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
