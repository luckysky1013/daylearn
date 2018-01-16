package com.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liujian
 * @date 2018/1/9
 */
public class EventTest {

    public static void main(String [] args){
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        //raise a start event
        context.start();
        EventDemo demo=(EventDemo)context.getBean("eventDemo");
        demo.getMessage();
        //stop a stop event
        context.stop();
    }
}
