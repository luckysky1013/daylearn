package com.asq.cas.realm;

import java.io.Serializable;

/**
 * @author liujian
 * @date 2018/10/31
 */
public class UserPrincipal implements Serializable{

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
