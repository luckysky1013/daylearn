package com.asq.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asq.jpa.domain.Account;

/**
 * @author liujian
 * @date 2018/1/23
 */
public interface AccountDao extends JpaRepository<Account,Integer> {
}
