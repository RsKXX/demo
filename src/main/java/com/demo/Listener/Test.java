package com.demo.Listener;

/**
 * @Author RuanShaoKang
 * @since 2021/7/29 15:32
 */
public class Test {
    public static void main(String[] args) {
        //定义事件源管理实践
        EventSource eventSource = new EventSource();
        Listener listener = new Listener();

        // 注册监听，往事件源添加监听
        eventSource.addEventListener(listener);

        // 模拟事件触发
        Event event = new Event("HelloWorld");
        // 用事件源激活事件，最终执行的是监听实现类里的@Override方法
        eventSource.notifyEvent(event);

    }
}
