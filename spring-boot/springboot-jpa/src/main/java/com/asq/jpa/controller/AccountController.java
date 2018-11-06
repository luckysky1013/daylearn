package com.asq.jpa.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.asq.jpa.dao.AccountDao;
import com.asq.jpa.domain.Account;

/**
 * @author liujian
 * @date 2018/1/23
 */

@RestController
@RequestMapping(value = "accounts")
public class AccountController {
    @Autowired
    AccountDao accountDao;

    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountDao.findAll();
    }

    /**
     * 增加
     * @param account
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String addAccount(@ModelAttribute Account account){
        Account account1=accountDao.saveAndFlush(account);
        return account1.toString();
    }

    /**
     * PUT 更新全部  PATCH 更新部分信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateAccoumt(@PathVariable("id") int id,
                                @ModelAttribute Account account){
        Account account1=accountDao.getOne(id);
        account1.setMoney(account.getMoney());
        account1.setName(account.getName());
        accountDao.save(account);
        return "success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  Account getAccountById(@PathVariable("id") int id){
        return accountDao.findOne(id);
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public List<Account> delete(@PathVariable("id")int id){
        accountDao.delete(id);
        return accountDao.findAll();
    }
}
