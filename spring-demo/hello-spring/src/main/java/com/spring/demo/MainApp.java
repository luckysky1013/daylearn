package com.spring.demo;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author liujian
 * @date 2018/1/8
 */
public class MainApp {

    public static void main(String []args){
    /*    ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld obj=(HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        XmlBeanFactory xmlBeanFactory=new XmlBeanFactory(new ClassPathResource("beans.xml"));
        HelloWorld obj1=(HelloWorld) xmlBeanFactory.getBean("helloWorld");
        obj1.getMessage();*/
        AbstractApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld objA=(HelloWorld) context.getBean("test");
        objA.getMessage();
        context.registerShutdownHook();
    }
}
