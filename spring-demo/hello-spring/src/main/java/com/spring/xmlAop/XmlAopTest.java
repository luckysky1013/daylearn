package com.spring.xmlAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liujian
 * @date 2018/1/9
 */
public class XmlAopTest {

    public static void main(String []args){
        ApplicationContext context=new ClassPathXmlApplicationContext("aop.xml");

        People people=(People) context.getBean("people");
        people.getAge();
        people.getName();
        people.printThrowException();
    }
}
