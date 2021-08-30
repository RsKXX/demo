package com.demo.config.websocketconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


/**
 * @author : guoxinze
 * Date: 2021/5/7
 * Time: 15:23
 * Description:
 */

@EnableWebSocketMessageBroker
@EnableWebSocket
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Autowired
    private WebSocketInterceptor webSocketInterceptor;
//    @Bean
//    public WebSocketInterceptor createBean(){
//        return new WebSocketInterceptor();
//    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册一个Stomp的节点（endpoint）,并指定使用SockJS协议。
        registry.addEndpoint("/ws-endpoint/").setHandshakeHandler(new UserHandshakeHandler())
            .setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(webSocketInterceptor);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 启动广播模式代理，只有符合的的路径才发送消息 代理将会处理前缀为“/topic”的消息
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
        //处理指定用户发送消息 点对点推送默认添加前缀为/user   当配置了enableSimpleBroker时，推送的前缀必须加上配置的路径
        registry.setUserDestinationPrefix("/user");
    }
}
