package com.springboot.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mybatis.dao.AccountMapper;
import com.springboot.mybatis.dao.AccountXmlMapper;
import com.springboot.mybatis.domain.Account;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void transfer() throws RuntimeException{
        accountMapper.update("test1",1000,1);//用户1减10块 用户2加10块
        int i=1/0;
        accountMapper.update("test2",1000,2);
    }
}