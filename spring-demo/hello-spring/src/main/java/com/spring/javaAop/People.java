package com.spring.javaAop;

/**
 * @author liujian
 * @date 2018/1/9
 */
public class People {
    private int age;
    private String name;

    public int getAge() {
        System.out.println("age :"+age);
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        System.out.println("name :"+name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printThrowException(){
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }
}
