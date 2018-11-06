package com.asq.mysql.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author liujian
 * @date 2018/10/10
 * 注意：
 * 在使用jpa时，使用entity自动建表，必须对实体类实现序列化，这样建表时的字段才是按照既定的顺序
 */
@Entity
public class Student implements Serializable{

	private static final long serialVersionUID = -4677332109833365933L;
	@Id
	@GenericGenerator(name="uuidGenerator",strategy = "com.asq.mysql.common.Base58UuidGenerator")
	@GeneratedValue(generator = "uuidGenerator")
	@Column
	private String id;

	@Column
	private String name;

	@Column
	private String age;

	@Column
	private String address;

	@Column
	private String schoolName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
