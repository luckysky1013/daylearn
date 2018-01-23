package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.UserRepository;
import com.example.springboot.domain.User;

/**
 * @author liujian
 * @date 2018/1/16
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable
    public User getById(Long id){
        System.out.println("从数据库中查询");
        User user=userRepository.findOne(id);
        return user;
    }

    @CacheEvict(value = "user_info",allEntries = true)
    public void update(){
        System.out.println("clear cache");
    }
}
