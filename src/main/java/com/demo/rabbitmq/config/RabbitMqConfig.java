package com.demo.rabbitmq.config;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnsCallback;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class RabbitMqConfig {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  /**
   * 自定义JSON消息序列化器, 默认就是json，如果是protobuf，则直接发送转化后的字节数组
   */
  @Bean
  public MessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @PostConstruct
  public void configureRabbitTemplate() {
    // 比如在这里设置接收消息后的回调方法
//    rabbitTemplate.setConfirmCallback(new ConfirmCallbackImpl());
//    rabbitTemplate.setReturnsCallback(new ReturnsCallbackImpl());
  }


  /**
   * 成功后的回调方法
   */
  public static class ConfirmCallbackImpl implements ConfirmCallback {

    /**
     * 实现confirm方法
     *
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

    }
  }


  /**
   * 失败后的回调方法
   */
  public static class ReturnsCallbackImpl implements ReturnsCallback {


    @Override
    public void returnedMessage(ReturnedMessage returned) {

    }
  }
}
