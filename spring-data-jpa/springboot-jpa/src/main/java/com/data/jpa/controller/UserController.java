package com.data.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import com.data.jpa.domian.User;
import com.data.jpa.repository.UserRepository;

/**
 * @author liujian
 * @date 2018/6/5
 */
@RestController
public class UserController {

	/**
	 * Rest 风格的 URL.
	 * 以 CRUD 为例:
	 * 新增: /user POST
	 * 修改: /user/1 PUT update?id=1
	 * 获取: /user/1 GET get?id=1
	 * 删除: /user/1 DELETE delete?id=1
	 *
	 * 如何发送 PUT 请求和 DELETE 请求呢 ?
	 * 1. 需要在web.xml配置 HiddenHttpMethodFilter
	 * 2. 需要发送 POST 请求
	 * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
	 * 在 SpringMVC 的目标方法中如何得到 id 呢? 使用 @PathVariable 注解
	 *
	 */

	@Autowired
	private UserRepository repository;

	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> users() {
		return repository.findAll();
	}

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User addUser(User user) {
		return repository.save(user);
	}

	/**
	 * 根据id查询单个用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User findUserById(@PathVariable Long id) {
		return repository.findOne(id);
	}

	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable Long id) {
		try {
			repository.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 更新用户
	 * 注意点：form表单提交接收不到参数数据 ，需在web.xml添加过滤器
	 * @param id
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable Long id,  User user) {
		User oldUser = repository.findOne(id);
		oldUser.setAddress(user.getAddress());
		oldUser.setAge(user.getAge());
		oldUser.setName(user.getName());
		return repository.save(oldUser);
	}

	/**
	 * 查询大于多少岁的用户（自定义查询）
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/user/age",method = RequestMethod.GET)
	public List<User> age( int age){
		return repository.nativeQuery(age);
	}

	/**
	 * put和delete 方法都不支持表单数据传递，接收不到参数
	 * 解决方法：
	 * 	1.如下 参数放在url路径
	 * 	2.在web.xml添加过滤器
	 * 	3.spring boot 下 新建过滤器类，继承HttpPutFormContentFilter
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/user/{name}/{age}" ,method = RequestMethod.DELETE)
	public boolean deleteWhere(@PathVariable String name,@PathVariable int  age){
		repository.deleteQuery(name,age);
		return true;
	}

	@RequestMapping(value = "/user/page",method = RequestMethod.GET)
	public List<User> userPage(int offset,int limit){
		User user=new User();
		user.setLimit(limit);
		user.setOffset(offset);
		PageRequest pageRequest=new PageRequest(user.getOffset()-1,user.getLimit());
		return repository.findAll(pageRequest).getContent();
	}
}
