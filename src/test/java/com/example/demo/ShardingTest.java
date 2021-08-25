package com.example.demo;

import com.demo.Application;

import com.demo.sharding.StudentService;
import com.demo.sharding.data.StudentInfoDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author RuanShaoKang
 * @since 2021/8/24 16:36
 */
@SpringBootTest(classes = Application.class)
public class ShardingTest {
    @Autowired
    protected StudentService studentService;
    @Test
    public void add() {
        StudentInfoDO student = new StudentInfoDO();
        student.setAge(14).setClassId(1L).setClassName("4班").setName("wang");
        StudentInfoDO student1 = new StudentInfoDO();
        student1.setAge(14).setClassId(2L).setClassName("5班").setName("zhao");
        StudentInfoDO student2 = new StudentInfoDO();
        student2.setAge(14).setClassId(3L).setClassName("6班").setName("li");
        studentService.addStudent(student);
        studentService.addStudent(student1);
        studentService.addStudent(student2);
    }
}
