package com.itheima.service;

import java.util.List;

import com.itheima.domain.Customer;

public interface CustomerService {

	void save(Customer customer);

	void update(Customer customer);

	void delete(Long id);

	Customer findbyId(long id);

	List<Customer> findAll();

}
