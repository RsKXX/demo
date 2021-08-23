package com.demo.rabbitmq.license;


import com.demo.data.Student;
import com.demo.rabbitmq.constant.RabbitMqConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: zhanjw
 * @data: 2021/05/28 13:36:00
 * @description:
 */
@Component
@RabbitListener(queues = RabbitMqConstant.QUEUE_STUDENT_INFO)
@Slf4j
@RequiredArgsConstructor
public class StudentInfoListener {



  @RabbitHandler
  public void studentProto(byte[] input) {

  }

  @RabbitHandler
  public void studentJson(Student student) {
    System.out.println(student);
  }

  @RabbitHandler
  public void studentJson(String studentInfo) {
    System.out.println(studentInfo);
  }

}
