package com.asq.jdbctemplate.service;

import java.util.List;

import com.asq.jdbctemplate.domain.Account;

/**
 * @author liujian
 * @date 2018/1/23
 */
public interface AccountService {

    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
