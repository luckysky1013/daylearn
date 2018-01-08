package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

//这是一个Spring的配置类，用来指定在创建对象的时候是从那些包下面扫描
@ComponentScan({"com.itheima"})
@Import(JdbcConfig.class)//引入其他配置项，将对象存到Spring容器里面
@PropertySource({"classpath:com/itheima/config/jdbcConfig.properties"})
public class SpringConfiguration {

}
