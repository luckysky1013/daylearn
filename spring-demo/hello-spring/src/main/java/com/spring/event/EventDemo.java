package com.spring.event;

/**
 * @author liujian
 * @date 2018/1/9
 */
public class EventDemo {
    private String message;

    public void setMessage(String message){
        this.message=message;
    }

    public void getMessage(){
        System.out.println(" message is " +message);
    }
}
