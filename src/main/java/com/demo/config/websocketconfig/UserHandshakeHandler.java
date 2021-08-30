package com.demo.config.websocketconfig;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

/**
 * @author : guoxinze
 * Date: 2021/8/5
 * Time: 16:33
 * Description:
 */

@Slf4j
public class UserHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        // 获取例如 wss://localhost/websocket/1 订阅地址
        // 中的最后一个用户 id 参数作为用户的标识,
        // 为实现发送信息给指定用户做准备
        // 这里使用session的id
        final String path = request.getURI().getPath();
        final String sessionId = StrUtil.sub(path, StrUtil.ordinalIndexOf(path, "/", 3) + 1, StrUtil.ordinalIndexOf(path, "/", 4));
        log.info("连接成功sessionID："+sessionId);
        return () -> sessionId;
    }
}