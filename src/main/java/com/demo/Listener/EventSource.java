package com.demo.Listener;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author RuanShaoKang
 * @since 2021/7/29 14:26
 */
public class EventSource {
    private List<EventListener> list = new ArrayList<>();
    public EventSource(){
        super();
    }
    public void addEventListener(EventListener eventListener){
        list.add(eventListener);
    }
    public void removeEventListener(EventListener eventListener){
        list.remove(eventListener);
    }
    public void notifyEvent(Event event){
        for (EventListener eventListener : list) {
            eventListener.handleEvent(event);
        }
    }
}
