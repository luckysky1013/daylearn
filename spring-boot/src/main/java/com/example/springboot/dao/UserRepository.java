package com.example.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.domain.User;

/**
 * @author liujian
 * @date 2018/1/16
 */

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUserName(String userName);
}
