package com.asq.mysql.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.asq.mysql.domain.Student;

/**
 * @author liujian
 * @date 2018/10/10
 */
public interface StudentRepository extends JpaRepository<Student,String>,JpaSpecificationExecutor<Student>,Serializable{
}
