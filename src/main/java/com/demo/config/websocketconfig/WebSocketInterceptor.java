package com.demo.config.websocketconfig;


import com.demo.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Objects;

@Slf4j
@Component
public class WebSocketInterceptor implements ChannelInterceptor {
    @Autowired
    public RedisService redisService;
    /**
     * 断开连接的时候打印一下日志
     *
     * @param channel
     * @return
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        StompCommand command = accessor.getCommand();
        if (Objects.equals(StompCommand.CONNECT, command)) {
            log.info(MessageFormat.format("session={0} 的 WebSocket 已经连接", accessor.getSessionId()));
        }
        //用户已经断开连接
        if (StompCommand.DISCONNECT.equals(command)) {
            log.warn(MessageFormat.format("session={0} 的WebSocket连接已经断开", accessor.getSessionId()));
        }
    }

}
