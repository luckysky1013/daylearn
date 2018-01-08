package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.Customer;

public interface CustomerDao {

	void save(Customer customer) throws SQLException;

	void update(Customer customer) throws SQLException;

	void delete(Long id) throws SQLException;

	Customer findbyId(long id) throws SQLException;

	List<Customer> findbyId() throws SQLException;

}
