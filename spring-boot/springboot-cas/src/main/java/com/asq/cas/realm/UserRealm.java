package com.asq.cas.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.asq.cas.domian.User;
import com.asq.cas.repository.UserRepository;

/**
 * @author liujian
 * @date 2018/10/31
 */
public class UserRealm extends AuthorizingRealm {

	private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

	@Autowired
	private UserRepository userRepository;

	/**
	 * 用户认证处理
	 * @return
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		SimpleAuthenticationInfo info = null;
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		if (username == null) {
			logger.error("用户名为空");
			throw new AccountException("null username are not allowed by this realm");
		}
		if (token.getPassword().length < 1) {
			throw new UnknownAccountException("password is error");
		}
		try {
			User user = userRepository.findByUsername(username);
			if (user != null) {
				info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
			} else {
				throw new AuthenticationException("没有这个用户");
			}
		} catch (Exception e) {
			throw new AuthenticationException(e.getMessage());
		}
		logger.info("用户" + username + "登陆");
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if(principals==null){
			throw new AuthenticationException("PrincipalCollection method argument cannot be null.");
		}
		Object obj=getAvailablePrincipal(principals);
		User user= (User) obj;
		SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
		return info;
	}

}
