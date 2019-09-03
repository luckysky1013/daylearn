package com.springboot.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mybatis.dao.AccountMapper;
import com.springboot.mybatis.domain.Account;

/**
 * @author liujian
 * @date 2018/1/23
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }
    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }
    public int delete(int id) {
        return accountMapper.delete(id);
    }
    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }
    public List<Account> findAccountList() {
        return accountMapper.findAll();
    }

    public int updateBy(Account account) {
        return accountMapper.updateBy(account);
    }
}