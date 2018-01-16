package com.spring.customevent;

import org.springframework.context.ApplicationEvent;

/**
 * @author liujian
 * @date 2018/1/9
 */
public class CustomEvent extends ApplicationEvent{
    public CustomEvent(Object source) {
        super(source);
    }
    @Override
    public String toString(){
        return "my custom event";
    }
}
