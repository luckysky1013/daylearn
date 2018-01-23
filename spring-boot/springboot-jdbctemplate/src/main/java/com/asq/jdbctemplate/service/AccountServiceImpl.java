package com.asq.jdbctemplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asq.jdbctemplate.dao.AccountDao;
import com.asq.jdbctemplate.domain.Account;

/**
 * @author liujian
 * @date 2018/1/23
 */
@Service
public class AccountServiceImpl  implements AccountService{
    @Autowired
    private AccountDao accountDao;
    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDao.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDao.findAccountList();
    }
}
