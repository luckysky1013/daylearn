package com.asq.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujian
 * @date 2018/3/14
 * 注意事项：
 * 1.代码没有问题，但是使用idea直接run或debug会报404
 * 2.使用Maven Project—Plugins里面的run可以
 */
@Controller
public class IndexController {

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(){
		return "index";
	}
}
