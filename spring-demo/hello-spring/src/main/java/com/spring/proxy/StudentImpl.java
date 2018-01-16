package com.spring.proxy;

/**
 * @author liujian
 * @date 2018/1/9
 */
public class StudentImpl implements  Student {
    @Override
    public void study() {
        System.out.println("学生学习的方法");
    }
}
