package com.example.springboot.dao;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.domain.User;

/**
 * @author liujian
 * @date 2018/1/16
 */
@Repository
@CacheConfig(cacheNames = "post")
public interface UserRepository extends JpaRepository<User,Long>{

    @Cacheable(key = "#p0")
    User findByUserName(String userName);

    User findByUserNameOrEmail(String username,String email);
}
