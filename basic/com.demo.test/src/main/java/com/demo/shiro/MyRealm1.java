package com.demo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm1 implements Realm{

	public String getName() {
		// TODO Auto-generated method stub
		return "myrealm1";
	}

	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		//仅支持usernamepasswordtoken类型的token
		return token instanceof UsernamePasswordToken;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username=(String)token.getPrincipal();
		String password=new String((char[])token.getCredentials());
		if(!"zhang".equals(username)){
			throw new UnknownAccountException();
		}
		if(!"123".equals(password)){
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(username,password,getName());
	}

}
