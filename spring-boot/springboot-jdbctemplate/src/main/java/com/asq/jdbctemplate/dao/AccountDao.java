package com.asq.jdbctemplate.dao;

import java.util.List;

import com.asq.jdbctemplate.domain.Account;

/**
 * @author liujian
 * @date 2018/1/23
 */
public interface AccountDao {

    int add(Account account);

    int update(Account account);

    int delete(int id );

    Account findAccountById(int id);

    List<Account> findAccountList();
}
