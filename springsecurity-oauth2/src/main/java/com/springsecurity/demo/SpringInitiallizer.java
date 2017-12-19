package com.springsecurity.demo;

import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by liujian on 2017/12/11
 * 配置DispatcherServlet、初始化Spring MVC容器和Spring容器，SpringMVC相关的信息
 * 同时还注册了一个拦截器。
 */

public class SpringInitiallizer extends AbstractAnnotationConfigDispatcherServletInitializer{
    //获取spring应用容器的配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringConfiguration.class};
    }
    //获取springmvc 应用容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    //指定需要由DispatcherServlet映射的路径，这里给定的是"/"，意思是由DispatcherServlet处理所有向该应用发起的请求。
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        Filter [] singleton={new CORSFilter()};
        return singleton;
    }
}
