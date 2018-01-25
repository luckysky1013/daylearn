package com.springboot.mybatis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.mybatis.domain.Account;
import com.springboot.mybatis.service.AccountService;
import com.springboot.mybatis.service.AccountXmlService;

/**
 * @author liujian
 * @date 2018/1/23
 */
@RestController
@RequestMapping("/accountXml")
public class AccountXmlController {

    @Autowired
    AccountXmlService accountService;

   @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/findOne/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccount(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        int t= accountService.update(name,money,id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id")int id) {
        int t= accountService.delete(id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {
        Account account=new Account();
        account.setName(name);
        account.setMoney(money);
        int t= accountService.add(account);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }
    }
    @RequestMapping(value = "/addList", method = RequestMethod.GET)
    public String postAccount() {
       List<Account> list =new ArrayList<>();
       for (int i=0;i<100;i++){
           Account account=new Account();
           account.setName("name"+i);
           account.setMoney(i);
           list.add(account);
       }
        int t= accountService.add(list);
        if(t!=1) {
            return "success";
        }else {
            return "fail";
        }
    }
}
