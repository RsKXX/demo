package com.demo.aop.service.impl;

import com.demo.aop.service.NewService;
import org.springframework.stereotype.Service;

/**
 * @Author RuanShaoKang
 * @since 2021/8/9 15:42
 */
@Service
public class NewServiceImpl implements NewService {
    private String name;
    @Override
    public void pr() {
        name = "引入";
        System.out.println(name);
    }
}
