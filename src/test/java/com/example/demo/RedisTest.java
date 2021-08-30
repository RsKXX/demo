package com.example.demo;

import com.demo.Application;
import com.demo.redis.DemoRedis;
import com.demo.sharding.StudentService;
import com.demo.sharding.data.StudentInfoDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author RuanShaoKang
 * @since 2021/8/30 16:04
 */
@SpringBootTest(classes = Application.class)
public class RedisTest {
    @Autowired
    protected DemoRedis demoRedis;
    @Test
    public void test() {
        demoRedis.getData();
    }
}
