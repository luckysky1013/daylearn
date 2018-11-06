package com.asq.cas.cofig;

import java.util.*;

import javax.servlet.Filter;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asq.cas.realm.UserRealm;

/**
 * @author liujian
 * @date 2018/10/31
 */
@Configuration
public class ShiroConfig {

	private static  final Logger logger= LoggerFactory.getLogger(ShiroConfig.class);

	//cas server 地址
	public static final String casServerUrlPrefix="https:localhost:8443/cas";
	//cas 登录页面
	public static final String casLoginUrl=casServerUrlPrefix+"/login";
	//cas 登出页面地址
	public static final String casLogoutUrl=casServerUrlPrefix+"/logout";
	//当前工程对面提供的服务地址
	public static final String shiroServerUrlPrefix="localhost:8081";
	//cas url过滤
	public static final String casFilterUrlPattern="/cas";
	//登录地址
	public static final String loginUrl=casLoginUrl+"?service="+shiroServerUrlPrefix+casFilterUrlPattern;
	//登出地址
	public static final String logoutUrl=casLogoutUrl+"?service"+shiroServerUrlPrefix;
	//登录成功地址
	public static final String loginSuccessUrl="/home";
	//权限认证失败跳转地址
	public static final String unauthorizedUrl="/error/403.html";

	/**
	 * redis 共享session , 修改session的共享域
	 * @return
	 */
	@Bean
	public ServletContainerSessionManager servletContainerSessionManager() {
		ServletContainerSessionManager d = new ServletContainerSessionManager();
		//d.getSessionIdCookie().setDomain(cookie_domain);
		return d;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager defaultWebSecurityManager() {
		DefaultWebSecurityManager dsm = new DefaultWebSecurityManager();
		List<Realm> realms = new ArrayList<>();
		realms.add(chsiRealm());
		dsm.setRealms(realms);
		//dsm.setSubjectFactory(defaultWebSubjectFactory());
		//dsm.setSessionManager(defaultWebSessionManager());
		//设置 自动登录
		dsm.setRememberMeManager(rememberMeManager());
		dsm.setSessionManager(servletContainerSessionManager());
		dsm.setCacheManager(ehCacheManager());
		return dsm;
	}

	@Bean(name = "shiroFilterFactoryBean")
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean sf = new ShiroFilterFactoryBean();
		sf.setSecurityManager(defaultWebSecurityManager());
		sf.setSuccessUrl("/index.html");
		//重写了登陆过滤器，这个配置需要去掉，避免重定向死循环
		//sf.setLoginUrl(shiroMainProperties.getLoginUrl());
		sf.setUnauthorizedUrl(unauthorizedUrl);
		Map<String, Filter> filters = new HashMap<>();
		//添加过滤器
		filters.put("CHSI", chsiFilter());
		sf.setFilters(filters);
		return sf;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor auth = new AuthorizationAttributeSourceAdvisor();
		auth.setSecurityManager(defaultWebSecurityManager());
		return auth;
	}

	//--------------------- 新职登录/学信登录/QQ登录/微信登录/微博登录 ---------------------
	@Bean
	public Realm userRealm() {
		UserRealm realm = new UserRealm();
		realm.setDefaultRoles("CAS_USER");
		realm.setCasServerUrlPrefix(chsiProperties.getCasServerUrlPrefix());
		realm.setCasService(chsiProperties.getCasService());
		return realm;
	}

	@Bean
	public CasFilter chsiFilter() {
		CasFilter casFilter = new CasFilter();
		// 登录失败后跳转的URL，也就是 Shiro 执行 CasRealm 的 doGetAuthenticationInfo 方法向CasServer验证tiket
		casFilter.setSuccessUrl(loginSuccessUrl);
		casFilter.setFailureUrl(unauthorizedUrl);
		return casFilter;
	}

	//shiro“记住密码”配置
	@Bean
	public SimpleCookie rememberMeCookie() {
		SimpleCookie rememberMeCookie = new SimpleCookie("rememberMeCookie");
		rememberMeCookie.setHttpOnly(true);
		rememberMeCookie.setMaxAge(10 * 24 * 3600);
		return rememberMeCookie;
	}

	@Bean
	public CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
		rememberMeManager.setCipherKey(Base64.decode("FjbNm1avvGmWE9CY2HqV75=="));
		rememberMeManager.setCookie(rememberMeCookie());
		return rememberMeManager;
	}

	@Bean(name = "ehCacheManager")
	public EhCacheManager ehCacheManager() {
		return new EhCacheManager();
	}
}
