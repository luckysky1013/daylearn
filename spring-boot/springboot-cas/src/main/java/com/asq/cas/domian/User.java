package com.asq.cas.domian;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author liujian
 * @date 2018/10/31
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

	private static final long serialVersionUID = -2542988777286189125L;
	@Id
	@Column
	private int id;

	@Column
	private String username;

	@Column
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
