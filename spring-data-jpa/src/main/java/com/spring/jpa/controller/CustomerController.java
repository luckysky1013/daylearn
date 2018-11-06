package com.spring.jpa.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.spring.jpa.domian.Customer;
import com.spring.jpa.repository.CustomerRepository;

/**
 * @author liujian
 * @date 2018/6/4
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	/**
	 * 初始化数据
	 */
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public void index(){
		repository.save(new Customer("jian","liu"));
		repository.save(new Customer("taylor","swift"));
	}

	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Customer> findAll(){
		List<Customer>  customers= repository.findAll();
		for (Customer customer:customers){
			System.out.println(customer.toString());
		}
		return  customers;
	}


	@RequestMapping(value = "/findOne/{id}")
	public Customer findOne(@PathVariable Long id){
		Customer customer=repository.findOne(id);
		System.out.println(customer.toString());
		return customer;
	}

	@DeleteMapping (value = "/delete")
	public boolean delete(long id){
		try {
			repository.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
