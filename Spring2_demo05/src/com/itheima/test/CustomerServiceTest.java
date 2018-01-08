package com.itheima.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.config.SpringConfiguration;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
//测试类
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfiguration.class})
public class CustomerServiceTest {
	@Autowired
	private CustomerService customerService = null;
	@Test
	public void testSave() {
		Customer customer = new Customer();
		customer.setCust_name("测试专用");
		customerService.save(customer);
	}

	@Test//测试更新
	public void testUpdate() {
		Customer customer = new Customer();
		customer.setCust_id(7L);
		customer.setCust_name("小贱贱");
		customerService.update(customer);
	}

	@Test//测试删除
	public void testDelete() {
		customerService.delete(6L);
	}

	@Test//测试通过id查找客户
	public void testFindbyId() {
		Customer customer = customerService.findbyId(7L);
		System.out.println(customer);
	}

	@Test
	public void testFindAll() {
		List<Customer> list = customerService.findAll();
		for (Customer customer : list) {
			System.out.println(customer);
			
		}
	}

}
