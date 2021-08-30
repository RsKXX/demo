package com.demo;

import com.demo.config.redisconfig.JacksonConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author RuanShaoKang
 * @since 2021/6/21 15:45
 */
@EnableScheduling
@MapperScan("com.demo.sharding.dao.mapper")
@SpringBootApplication(scanBasePackages = {"com.demo"})
@Import({JacksonConfig.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
