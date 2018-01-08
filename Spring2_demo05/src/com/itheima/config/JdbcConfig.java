package com.itheima.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//在本类中我们获取jdbc的dbutils的QueryRunner对象
@Configuration//制定这是一个配置类
public class JdbcConfig {
	//通过Spring的el表达式，为属性赋值
	@Value("${jdbc.driver}")
	private String diverClass;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	//获取数据库连接池对象
	@Bean(name="ds") //将当前方法返回的参数放进Spring容器里面
	public DataSource getDataSource(){
		try {
			//创建对象
			ComboPooledDataSource ds = new ComboPooledDataSource();
			//获取数据库连接信息
			ds.setDriverClass(diverClass);
			ds.setJdbcUrl(url);
			ds.setUser(username);
			ds.setPassword(password);
			//返回数据库连接对象
			return ds;
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return null;
	}
	//将QueryRunner对象fangjinSpring容器里面；
	@Bean(name="runner")
	public QueryRunner getQueryRunner(@Qualifier("ds") DataSource ds){//使用Qualifier为参数对象赋值
		QueryRunner runner = new QueryRunner(ds);
		return runner;
	}
	
}
