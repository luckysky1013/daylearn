package com.itheima.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
//创建CustomerService对象

@Service("customerService")
@Scope(value="prototype")//设置对象为多例
public class CustomerServiceImpl implements CustomerService {
	
	//注入CustomerDao对象
	@Autowired
	private CustomerDao dao = null;
	/**
	 * 保存客户信息
	 */
	@Override
	public void save(Customer customer) {
		try {
			//执行保存
			dao.save(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改客户信息
	 */
	@Override
	public void update(Customer customer) {
		try {
			//执行更新
			dao.update(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除客户信息
	 */
	@Override
	public void delete(Long id) {
		try {
			//删除
			dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过id查找客户
	 */
	@Override
	public Customer findbyId(long id) {
		Customer customer = null;
		try {
			//执行查找
			customer = dao.findbyId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	/**
	 * 查询所有的客户信息
	 */

	@Override
	public List<Customer> findAll() {
		List<Customer> list = null;
		try {
			//执行查找
			list = dao.findbyId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
