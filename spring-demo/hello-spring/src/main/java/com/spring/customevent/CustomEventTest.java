package com.spring.customevent;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liujian
 * @date 2018/1/9
 */
public class CustomEventTest {

    public static void main(String []args){
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        CustomEventPublisher publisher=(CustomEventPublisher)context.getBean("customEventPublisher");
        publisher.publish();
        publisher.publish();
    }
}
