package com.springboot.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.helloworld.config.ConfigBean;
import com.springboot.helloworld.config.UserBean;

/**
 * @author liujian
 * @date 2018/1/23
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class, UserBean.class})
public class ConfigBeanController {

    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/configBean")
    public String asq(){
        return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }

    @Autowired
    UserBean userBean;

    @RequestMapping(value = "/userBean")
    public String user(){
        return userBean.getName()+" "+userBean.getAge();
    }
}
