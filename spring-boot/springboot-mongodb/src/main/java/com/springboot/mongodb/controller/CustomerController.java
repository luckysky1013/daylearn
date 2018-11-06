package com.springboot.mongodb.controller;

import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.dao.CustomerRepository;
import com.springboot.mongodb.entity.Customer;

/**
 * @author liujian
 * @date 2018/6/5
 */
@RestController(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository  repository;

	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public List<Customer> findAll(){
		return repository.findByLastName("jian");
	}

	@RequestMapping(value = "/save",method = RequestMethod.GET)
	public void save(){
		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));
	}

	@RequestMapping(value = "/{name}",method = RequestMethod.GET)
	public Customer findOne(@PathVariable String name){
		return repository.findByFirstName(name);
	}
}
