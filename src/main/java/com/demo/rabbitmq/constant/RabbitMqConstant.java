package com.demo.rabbitmq.constant;

/**
 * @Author RuanShaoKang
 * @since 2021/8/23 13:52
 */
public class RabbitMqConstant {
    public static final String EXCHANGE_DIRECT = "demo.exchange.direct";
    public static final String DEAD_LETTER_QUEUE = "demo.queue.dead-letter";

    /**
     * 学生信息的exchange
     */
    public static final String EXCHANGE_STUDENT_TOPIC = "demo.exchange.student.topic";
    /**
     * 学生信息队列
     */
    public static final String QUEUE_STUDENT_INFO = "demo.queue.student.info";
}
