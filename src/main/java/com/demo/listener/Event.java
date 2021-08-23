package com.demo.listener;

import java.util.EventObject;

/**
 * @Author RuanShaoKang
 * @since 2021/7/29 14:25
 */

public class Event extends EventObject {
    private Object obj;


    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public Event(Object source) {
        super(source);
        this.obj = source;
    }

    public Object getObj(){
        return obj;
    }
}
