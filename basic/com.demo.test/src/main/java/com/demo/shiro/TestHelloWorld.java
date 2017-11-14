package com.demo.shiro;

import javax.security.auth.Subject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.junit.Assert;

public class TestHelloWorld {
	public static void main(String[] args) {
		//1获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		//2.获取SecurityManager对象，由工厂创建
		SecurityManager securityManager=factory.getInstance();
		//3.将SecurityManager对象绑定给SecurityUtils（安全工具类）
		SecurityUtils.setSecurityManager(securityManager);
		//4.获取subject对象
		org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
//		5.创建用户名密码身份验证token（即用户身份/凭证）
		UsernamePasswordToken token=new UsernamePasswordToken("zhang", "ddd");
		
		try{
			//登陆，验证身份
		subject.login(token);
		System.out.println("success");
		}catch(AuthenticationException e){
			e.printStackTrace();
		}
		
		Assert.assertEquals(true, subject.isAuthenticated());
		
		subject.logout();
	}
}
