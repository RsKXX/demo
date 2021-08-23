package com.demo.data;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author RuanShaoKang
 * @since 2021/7/27 15:34
 */
@Data
@Accessors(chain = true)
public class Student implements  Person,School{
    private String name;
    private Integer age;

    @Override
    public void getUsername() {
        System.out.println("my name");
    }

    @Override
    public void schoolName() {
        System.out.println("my school");
    }
}
