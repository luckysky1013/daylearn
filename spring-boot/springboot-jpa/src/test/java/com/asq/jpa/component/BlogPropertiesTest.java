package com.asq.jpa.component;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liujian
 * @date 2018/3/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BlogPropertiesTest {

	@Autowired
	private BlogProperties blogProperties;

	@Test
	public void test(){
		Assert.assertEquals(blogProperties.getName(),"aima");
		Assert.assertEquals(blogProperties.getTitile(),"spring boot");
	}
}
