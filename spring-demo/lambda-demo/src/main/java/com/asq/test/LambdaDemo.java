package com.asq.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author liujian
 * @date 2018/1/12
 */
public class LambdaDemo {
    @Test
    public void runnableDemo1(){
        //java8 之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("启动一个线程" );
            }
        }).start();

        //java8 方式
        new Thread(()->System.out.println("java8")).start();
    }

    @Test
    public void listDemo2(){
        List features= Arrays.asList("qinqin","jianjian");
        for (Object name:features){
            System.out.println(name);
        }

        features.forEach(n->System.out.println(n));
    }
}
