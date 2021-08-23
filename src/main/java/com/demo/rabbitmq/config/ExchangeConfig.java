package com.demo.rabbitmq.config;


import com.demo.rabbitmq.constant.RabbitMqConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {

  //---------------------死信队列开始

  /**
   * 死信队列跟交换机类型没有关系 不一定为directExchange  不影响该类型交换机的特性.
   */
  @Bean
  public Exchange directExchange() {
    return ExchangeBuilder.directExchange(RabbitMqConstant.EXCHANGE_DIRECT).durable(true).build();
  }

  /**
   * 死信队列
   *
   * @return
   */
  @Bean
  public Queue deadLetterQueue() {
    return QueueBuilder.durable(RabbitMqConstant.DEAD_LETTER_QUEUE).deadLetterExchange(RabbitMqConstant.EXCHANGE_DIRECT)
        .deadLetterRoutingKey("deadKey").build();
  }

  //---------------------死信部分结束
  /**
   * =========================================================== 学生数据topic 交换器 ===== start
   **/
  @Bean
  public TopicExchange studentExchange() {
    return new TopicExchange(RabbitMqConstant.EXCHANGE_STUDENT_TOPIC, true, false, null);
  }

  @Bean
  public Queue studentInfoQueue() {
    return new Queue(RabbitMqConstant.QUEUE_STUDENT_INFO, true, false, false);
  }


  @Bean
    public Binding studentInfoBinding() {
    //链式写法，绑定交换机和队列，并设置匹配键
    return BindingBuilder
        //绑定队列
        .bind(studentInfoQueue())
        //到交换机
        .to(studentExchange()).with(RabbitMqConstant.QUEUE_STUDENT_INFO);
  }

  /**
   * =========================================================== 学生数据topic 交换器 ===== end
   **/


}
