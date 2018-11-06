package com.asq.jdbctemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.asq.jdbctemplate.domain.Account;
import com.asq.jdbctemplate.service.AccountService;

/**
 * @author liujian
 * @date 2018/1/23
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String addAccount(@RequestParam(value = "name") String name,
                             @RequestParam(value = "money")double money){
        Account account=new Account();
        account.setName(name);
        account.setMoney(money);
        int t=accountService.add(account);
        if(t==1){
            return account.toString();
        }else{
            return "fail";
        }

    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public String updateAccoumt(@PathVariable("id") int id,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "money")int money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t=accountService.update(account);
        if(t==1){
            return account.toString();
        }else{
            return "fail";
        }
    }

    @RequestMapping(value = "/findOne/{id}",method = RequestMethod.GET)
    public  Account getAccountById(@PathVariable("id") int id){
        return accountService.findAccountById(id);
    }
}
