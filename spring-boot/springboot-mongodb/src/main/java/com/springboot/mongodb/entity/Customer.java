package com.springboot.mongodb.entity;

import org.springframework.data.annotation.Id;

/**
 * @author liujian
 * @date 2018/6/5
 */
public class Customer {

	@Id
	public String id;

	public String firstName;

	public String lastName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer() {
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
