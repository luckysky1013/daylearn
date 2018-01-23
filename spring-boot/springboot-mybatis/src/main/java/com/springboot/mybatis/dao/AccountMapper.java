package com.springboot.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.springboot.mybatis.domain.Account;

/**
 * @author liujian
 * @date 2018/1/23
 * 通过注解的方式
 */
@Mapper
public interface AccountMapper {

    @Insert("INSERT  INTO  account(name,money) VALUES (#{name},#{money})")
    public int add(@Param("name") String name,@Param("money")double money);

    @Update("UPDATE  account SET  name=#{name} ,money=#{money} WHERE id=#{id}")
    public int update(@Param("name")String name, @Param("money")double money,@Param("id") int id);

    @Delete("DELETE  FROM  account WHERE id=#{id}")
    public int delete(@Param("id") int id);

    @Select("SELECT * FROM  account WHERE  id=#{id}")
    public Account findAccount(@Param("id") int id);

    @Select("select id, name as name, money as money from account")
    public List<Account>  findAll();

}
