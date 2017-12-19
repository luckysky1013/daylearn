package com.asq.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liujian
 * @date 2017/12/12
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/welcome**",method = RequestMethod.GET)
    public ModelAndView welcomePage(){
        ModelAndView model=new ModelAndView();
        model.addObject("title","SpringSecurity hello world");
        model.addObject("message","this is welcome page");
        model.setViewName("hello");
        return  model;
    }

    @RequestMapping(value = "/admin**",method = RequestMethod.GET)
    public ModelAndView adminPage(){
        ModelAndView model=new ModelAndView();
        model.addObject("title","Spring Secutity Hello World");
        model.addObject("message","this is protected page");
        model.setViewName("admin");
        return model;
    }
}
