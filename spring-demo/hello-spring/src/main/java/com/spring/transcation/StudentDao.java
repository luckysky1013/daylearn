package com.spring.transcation;

import java.util.List;

import javax.sql.DataSource;

/**
 * @author liujian
 * @date 2018/1/10
 */
public interface StudentDao {

    public void setDataSource(DataSource sd);


    public void create(String name,int age,int marks,int year );

    public List<StudentMarks> listStudents();
}
