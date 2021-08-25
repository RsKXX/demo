package com.example.demo;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.demo.Application;
import com.demo.proxy.data.Student;
import com.demo.rabbitmq.constant.RabbitMqConstant;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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
//    Student student = new Student();
//    student.setAge(13).setName("李");
//    JSON parse = JSONUtil.parse(student);
//    rabbitTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_STUDENT_TOPIC, RabbitMqConstant.QUEUE_STUDENT_INFO, parse.toString());
  }
}
