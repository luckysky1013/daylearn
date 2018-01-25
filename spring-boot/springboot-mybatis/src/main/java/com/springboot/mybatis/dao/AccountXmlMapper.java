package com.springboot.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.springboot.mybatis.domain.Account;

/**
 * @author liujian
 * @date 2018/1/25
 */
@Mapper
public interface AccountXmlMapper {
    public int insert(@Param("account")Account account);

    public int insertList(@Param("accounts") List<Account> accounts);

    public int update(@Param("name")String name, @Param("money")double money,@Param("id") int id);

    public int delete(@Param("id") int id);

    public Account findAccount(@Param("id") int id);

    public List<Account> findAll();
}
