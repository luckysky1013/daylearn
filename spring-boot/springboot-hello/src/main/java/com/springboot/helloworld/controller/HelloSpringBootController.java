package com.springboot.helloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujian
 * @date 2018/1/22
 */
@RestController
public class HelloSpringBootController {

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @RequestMapping("/hello")
    public String index(){
        return "helloWorld";
    }

    @RequestMapping(value = "/asq")
    public String asq(){
        return name+" -- "+age;
    }
}
