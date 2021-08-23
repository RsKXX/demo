package com.example.demo;

import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.demo.Application;
import com.demo.data.Student;
import com.demo.rabbitmq.constant.RabbitMqConstant;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@SpringBootTest(classes = Application.class)
public class RabbitMQTest {

  @Autowired
  private RabbitTemplate rabbitTemplate;


  @Test
  public void sendMessageJson()  {
    Student student = new Student();
    student.setAge(12).setName("王");
    rabbitTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_STUDENT_TOPIC, RabbitMqConstant.QUEUE_STUDENT_INFO, "nihao");
  }

  @Test
  public void sendMessage1(){
    Student student = new Student();
    student.setAge(13).setName("李");
    JSON parse = JSONUtil.parse(student);
    rabbitTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_STUDENT_TOPIC, RabbitMqConstant.QUEUE_STUDENT_INFO, parse.toString());
  }
}
