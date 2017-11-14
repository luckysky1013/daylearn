package com.demo.utils;

import org.apache.commons.lang.StringUtils;

/**
 * StringUtils是commonlang3中的工具类
 * 主要封装了堆字符串操作的一系列方法
 * @author lucky
 *
 */
public class StringUtilsTest {
	
	public static void main(String[] args) {
		//判断字符串是否为空 ，为空 返回true
		StringUtils.isEmpty("");
		StringUtils.isEmpty(null);
		StringUtils.isEmpty(" ");
		
		//判断字符串是否不为空 ，为空返回false
		StringUtils.isNotEmpty(null);
		StringUtils.isNotEmpty("");
		StringUtils.isNotEmpty(" ");
		
		//判断字符串hellowolrd是否包含hello，包含返回true
		StringUtils.contains("helloworld", "hello");
		
		//判断字符串helloworld是否包含h字符，包含返回true
		StringUtils.contains("helloworld", 'h');
		
		//判断字符串str1是否包含str2，不区分大小写
		StringUtils.containsIgnoreCase("helloworld", "hello");
	
		//判断两个字符串是否相等 ，区分大小写
		StringUtils.equals("hello", "hello");

		//判断两个字符串是否相等，不区分大小写
		StringUtils.equalsIgnoreCase("hello", "Hello");
		
		//截取字符串
		StringUtils.substring("hello", 1, 2);
	}
}
