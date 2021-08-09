package com.demo.Listener;



/**
 * @Author RuanShaoKang
 * @since 2021/7/29 15:14
 */
public class Listener implements EventListener{
    protected void doExecutors(Event event){
        System.out.println(event);
    }

    @Override
    public void handleEvent(Event event) {
        doExecutors(event);
    }
}
