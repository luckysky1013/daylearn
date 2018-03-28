package com.asq.jpa.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liujian
 * @date 2018/3/16
 */
@Component
public class BlogProperties {

	@Value("${com.asq.name}")
	private String name;

	@Value("${com.asq.title}")
	private String titile;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}
}
