package com.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.data.jpa.domian.User;

/**
 * @author liujian
 * @date 2018/6/5
 */
public interface UserRepository extends JpaRepository<User,Long> {

	/**
	 * 自定义查询sql
	 * 查询大于多少岁的用户
	 * @param age
	 * @return
	 */
	@Query(value = "select  * from t_user where age>?1 ",nativeQuery =  true)
	public List<User> nativeQuery(int age);

	/**
	 * 根据姓名年龄 删除用户
	 * @Query注解好像只是用来查询的，
	 * 但是如果配合@Modifying注解一共使用，
	 * 则可以完成数据的删除、添加、更新操作。
	 */
	@Transactional
	@Modifying
	@Query(value = "delete  from t_user where name=?1 and age =?2 " ,nativeQuery = true)
	public void deleteQuery(String name ,int age );
}
