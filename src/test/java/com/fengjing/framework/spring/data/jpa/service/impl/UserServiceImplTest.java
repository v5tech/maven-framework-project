package com.fengjing.framework.spring.data.jpa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.fengjing.framework.spring.data.jpa.service.UserService;
import com.fengjing.framework.springmvc.model.Dept;
import com.fengjing.framework.springmvc.model.User;


@ContextConfiguration(locations={"classpath:spring-data-jpa.xml"})
@RunWith(value=SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@Test
	public void findUserById(){
		User user = userService.findUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void save(){
		
		User user=new User();
		user.setUsername("刘xx");
		Dept dept=new Dept();
		dept.setDeptname("文化部");
		user.setDept(dept);
		
		User u = userService.save(user);
		Assert.notNull(u);
		
	}
	
	@Test
	public void modifyById(){
		User user = userService.findUserById(1);
		user.setUsername("小李");
		userService.modifyById("小李",1);
	}
	
	@Test
	public void modifyUser(){
		
		User user = userService.findUserById(1);
		user.setUsername("小王");
		Dept dept=user.getDept();
		dept.setDeptname("研发部");
		user.setDept(dept);
		userService.modifyUser(user);
		
	}
	
	@Test
	public void deleteByUser(){
		
	}
	
	@Test
	public void deleteByUserId(){
		
	}
	
	
	@Test
	public void findByUsernameLike(){
		List<User> lists = userService.findByUsernameLike("小");
		for (User user : lists) {
			System.out.println(user);
			System.out.println("-----------------------");
		}
	}
	
	@Test
	public void findByIdLessThan(){
		List<User> lists = userService.findByIdLessThan(100);
		for (User user : lists) {
			System.out.println(user);
			System.out.println("-----------------------");
		}
	}
	
	/**
	 * 根据username查询 并按id降序排列
	 * @param username
	 * @return
	 */
	@Test
	public void findByUsernameLikeOrderByIdDesc(){
		List<User> lists = userService.findByUsernameLikeOrderByIdDesc("小");
		for (User user : lists) {
			System.out.println(user);
			System.out.println("-----------------------");
		}
	}
	
	
	@Test
	public void findByIdBetween(){
		List<User> lists = userService.findByIdBetween(1,10);
		for (User user : lists) {
			System.out.println(user);
			System.out.println("-----------------------");
		}
	}
	
	
	@Test
	public void findUserByDeptId(){
		List<User> lists = userService.findUserByDeptId(1);
		for (User user : lists) {
			System.out.println(user);
			System.out.println("-----------------------");
		}
	}
	
}
