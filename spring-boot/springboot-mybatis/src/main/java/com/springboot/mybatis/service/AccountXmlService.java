package com.springboot.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mybatis.dao.AccountMapper;
import com.springboot.mybatis.dao.AccountXmlMapper;
import com.springboot.mybatis.domain.Account;

/**
 * @author liujian
 * @date 2018/1/23
 */
@Service
public class AccountXmlService {
    @Autowired
    private AccountXmlMapper accountMapper;

    public int add(Account account) {
        return accountMapper.insert(account);
    }
    public int  add(List<Account> accounts){
        return  accountMapper.insertList(accounts);
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
}