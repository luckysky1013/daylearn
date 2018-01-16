package com.spring.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import com.spring.proxy.Student;

/**
 * @author liujian
 * @date 2018/1/9
 */
public class MyBeanProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("初始化之前做处理");
        //bean初始化之前做处理的方法
        if(s.equals("test")){
           HelloWorld helloWorld=(HelloWorld)o;
           helloWorld.setMessage("helloworld 处理后");
           return helloWorld;
        }

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("初始化之后做处理");
        return o;
    }
}
