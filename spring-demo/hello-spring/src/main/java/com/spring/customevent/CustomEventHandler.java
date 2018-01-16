package com.spring.customevent;

import org.springframework.context.ApplicationListener;

/**
 * @author liujian
 * @date 2018/1/9
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        System.out.println(customEvent.toString());
    }
}
