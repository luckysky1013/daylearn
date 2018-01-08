package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
@Repository("customerDao")//创建customerDao对象
@Scope("prototype")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired//注入QueryRunner对象
	QueryRunner runner = null;
	@Override
	public void save(Customer customer) throws SQLException {
		//构造sql语句和参数
		String sql = "insert into customer(cust_name,cust_source,cust_industry,cust_level,cust_address,cust_phone) values(?,?,?,?,?,?)";
		Object[] params = {customer.getCust_name(),customer.getCust_source(),customer.getCust_industry(),customer.getCust_level(),customer.getCust_address(),customer.getCust_phone()};
		//执行保存；
		int update = runner.update(sql, params);
		//获取执行结果
		String result = update==1?"保存成功":"保存失败";
		System.out.println(result);
	}
	/**
	 * 修改用户信息
	 * */
	@Override
	public void update(Customer customer) throws SQLException {
		//构造sql语句和参数
		String sql = "update customer set cust_name=?,cust_source=?,cust_industry=?,cust_level=?,cust_address=?,cust_phone=? where cust_id=?";
		Object[] params = {customer.getCust_name(),customer.getCust_source(),customer.getCust_industry(),customer.getCust_level(),customer.getCust_address(),customer.getCust_phone(),customer.getCust_id()};
		//执行保存；
		int update = runner.update(sql, params);
		//获取执行结果
		String result = update==1?"更新成功":"更新失败";
		System.out.println(result);
		
	}
	@Override
	public void delete(Long id) throws SQLException {
		//构造sql语句和参数
		String sql = "delete from customer where cust_id=?";
		//执行保存；
		int update = runner.update(sql, id);
		//获取执行结果
		String result = update==1?"删除成功":"删除失败";
		System.out.println(result);
		
	}
	@Override
	public Customer findbyId(long id) throws SQLException {
		//构造sql语句
		String sql = "select cust_id,cust_name,cust_source,cust_industry,cust_level,cust_address,cust_phone from customer where cust_id = ?";
		Customer customer = runner.query(sql, new BeanHandler<Customer>(Customer.class), id);
		//返回结果集
		return customer;
	}
	@Override
	public List<Customer> findbyId() throws SQLException {
		//构造sql语句
		String sql = "select cust_id,cust_name,cust_source,cust_industry,cust_level,cust_address,cust_phone from customer";
		List<Customer> list = runner.query(sql, new BeanListHandler<Customer>(Customer.class));
		//返回结果集
		return list;
	}

}
