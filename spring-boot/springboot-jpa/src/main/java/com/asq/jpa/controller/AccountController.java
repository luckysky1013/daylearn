package com.asq.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.asq.jpa.dao.AccountDao;
import com.asq.jpa.domain.Account;

/**
 * @author liujian
 * @date 2018/1/23
 */

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountDao accountDao;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountDao.findAll();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addAccount(@RequestParam(value = "name") String name,
                             @RequestParam(value = "money")double money){
        Account account=new Account();
        account.setName(name);
        account.setMoney(money);
        Account account1=accountDao.saveAndFlush(account);

        return account1.toString();

    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public String updateAccoumt(@PathVariable("id") int id,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "money")int money){
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        Account account1 = accountDao.save(account);
        return account1.toString();
    }

    @RequestMapping(value = "/findOne/{id}",method = RequestMethod.GET)
    public  Account getAccountById(@PathVariable("id") int id){
        return accountDao.findOne(id);
    }


}
