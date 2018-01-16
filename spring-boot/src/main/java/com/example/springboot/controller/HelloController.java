package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springboot.dao.UserRepository;
import com.example.springboot.domain.User;
import com.example.springboot.service.UserService;

/**
 * @author liujian
 * @date 2018/1/15
 */
@RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }


    @RequestMapping("/getUser")
    public User getUser(){
      User user=userRepository.findByUserName("aa");
      System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
      return user;
    }

    @RequestMapping(value = "/findById")
    public User findById(Long id) {
        //从数据库查询
        System.out.println(userService.getById(id).getUserName());

        //从缓存获取
        System.out.println(userService.getById(id).getUserName());

        //刷新缓存
        userService.update();

        //从数据库获取
        User user = userService.getById(id);
        System.out.println(user.getUserName());
        return user;
    }
}
