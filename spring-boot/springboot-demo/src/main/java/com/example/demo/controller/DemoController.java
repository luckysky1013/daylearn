package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujian
 * @date 2018/9/11
 * 注意事项：
 * 1 .@RestController和@Controller的	区别：
 * 		RestController= @ResponseBody+@Controller ，返回的直接是Json字符串，不能返回页面
 * 2 . 使用Controller 时，想要返回json，必须在方法名上添加@ResponseBody
 * 3 . 想要返回页面时，必须引入thymeleaf 模板
 */
@Controller
public class DemoController {

	/**
	 * 返回到index.html页面上
	 * @return
	 */
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String hello(){
		return "index";
	}

	/**
	 * 返回index json格式数据
	 * @return
	 */
	@RequestMapping(value = "/helloJosn",method = RequestMethod.GET)
	@ResponseBody
	public String helloJosn(){
		return "index";
	}

}
