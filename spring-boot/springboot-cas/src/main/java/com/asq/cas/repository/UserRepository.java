package com.asq.cas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asq.cas.domian.User;

/**
 * @author liujian
 * @date 2018/10/31
 */
public interface UserRepository extends JpaRepository<User,Integer> {

	public User findByUsername(String username);
}
