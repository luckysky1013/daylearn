package com.springboot.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.mongodb.entity.Customer;

/**
 * @author liujian
 * @date 2018/6/5
 */
public interface CustomerRepository extends MongoRepository<Customer,String>{

	public Customer findByFirstName(String firstName);

	public List<Customer> findByLastName(String lastName);
}
