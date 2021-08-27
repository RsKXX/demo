package com.demo.config;

import com.demo.redis.RedisListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @Author RuanShaoKang
 * @since 2021/7/16 9:19
 */
@Configuration
public class RedisConfiguration {
    /**
     * 定义消息监听者容器
     *
     * @param connectionFactory 连接工厂
     * @return RedisMessageListenerContainer
     */
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, RedisListener redisListener) {
        RedisMessageListenerContainer listenerContainer = new RedisMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.addMessageListener(redisListener, new PatternTopic("xxx"));
        return listenerContainer;
    }
}
