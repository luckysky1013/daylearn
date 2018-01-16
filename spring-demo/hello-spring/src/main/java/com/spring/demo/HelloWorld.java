package com.spring.demo;

/**
 * @author liujian
 * @date 2018/1/8
 */
public class HelloWorld {

    private String message;

    public void getMessage(){
        System.out.println("message is "+message);
    }

    public void setMessage(String message){
        this.message=message;
    }

    public HelloWorld() {
    }
    //初始化方法
    public void init(){
        System.out.println("bean 初始化方法");
    }
    //销毁方法
    public void destory(){
        System.out.println("bean 销毁方法");
    }
}
