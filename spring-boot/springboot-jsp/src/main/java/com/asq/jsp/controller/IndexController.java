package com.asq.jsp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujian
 * @date 2018/3/14
 */
@RestController
public class IndexController {

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(){
		return "index";
	}
}
