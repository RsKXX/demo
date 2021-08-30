package com.demo.redis;

import com.demo.sharding.data.StudentInfoDO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author RuanShaoKang
 * @since 2021/7/16 9:18
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class RedisListener implements MessageListener {

  private final SimpMessagingTemplate simpMessagingTemplate;

  /**
  *@author: RuanShaoKang
  *@date: 2021/8/30
  *@description: 监听redis send消息 同时广播获取的消息
  *@param: [message, bytes]
  *@return: void
  */
  @Override
  public void onMessage(Message message, byte[] bytes) {
      StudentInfoDO studentInfoDO = JsonUtil.read(message.getBody(), StudentInfoDO.class);
      simpMessagingTemplate.convertAndSend("/topic/message",studentInfoDO);
  }
}
