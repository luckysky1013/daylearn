package com.springsecurity.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by liujian on 2017/12/11
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springsecurity.demo")
//指定注解扫描的包
public class SpringConfiguration {

}
