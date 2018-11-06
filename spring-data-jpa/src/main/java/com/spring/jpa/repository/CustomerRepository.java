package com.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.domian.Customer;

/**
 * @author liujian
 * @date 2018/6/4
 */
public interface CustomerRepository extends JpaRepository<Customer,Long>{
}
