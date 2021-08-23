package com.demo.listener;

/**
 * @Author RuanShaoKang
 * @since 2021/7/29 15:09
 */
public interface EventListener extends java.util.EventListener {
    void handleEvent(Event event);
}
