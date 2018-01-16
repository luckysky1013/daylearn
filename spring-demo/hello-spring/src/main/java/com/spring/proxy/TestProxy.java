package com.spring.proxy;

/**
 * @author liujian
 * @date 2018/1/9
 */
public class TestProxy {

    public static void main(String []args){
        StudentProxy proxy=new StudentProxy();
        Student studentProxy= (Student) proxy.bind(new StudentImpl());
        studentProxy.study();
    }
}
