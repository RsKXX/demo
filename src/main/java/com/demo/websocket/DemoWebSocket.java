package com.demo.websocket;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

/**
 * @Author RuanShaoKang
 * @since 2021/8/25 16:54
 */

@RestController
@Slf4j
@RequiredArgsConstructor
public class DemoWebSocket {

    private final SimpMessagingTemplate simpMessagingTemplate;

    /**
    *@author: RuanShaoKang
    *@date: 2021/8/30
    *@description: 点对点推送消息
    *@param: [sessionId, message]
    *@return: void
    */
    public void sendMessage(String sessionId,String message){
        simpMessagingTemplate.convertAndSendToUser(sessionId, "/topic/message", message+sessionId);
    }

    /**
    *@author: RuanShaoKang
    *@date: 2021/8/30
    *@description: 接受消息，获取sessionId,消息内容，调用send方法发生消息
    *@param: [data, message]
    *@return: void
    */
    @MessageMapping("/demo/message")
    public void acceptMessage(Map<String, String> data, Message<?> message){
        String name = data.get("name");
        String age = data.get("age");
        String sessionId = (String) message.getHeaders().get("simpSessionId");
        String temp = "name:"+name+",age:"+age;
        sendMessage(sessionId,temp);
    }
}
