package com.spring.javaAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.Period;

/**
 * @author liujian
 * @date 2018/1/9
 */
public class JavaAopTest {
    public static void main(String []args){
        ApplicationContext context=new ClassPathXmlApplicationContext("javaAop.xml");
        People people=(People)context.getBean("people");
        people.getAge();
        people.getName();
        //people.printThrowException();
    }
}
