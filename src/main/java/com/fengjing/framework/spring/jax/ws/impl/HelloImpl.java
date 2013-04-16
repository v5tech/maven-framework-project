package com.fengjing.framework.spring.jax.ws.impl;

import java.util.ArrayList;
import java.util.List;

import com.fengjing.framework.spring.jax.ws.Dept;
import com.fengjing.framework.spring.jax.ws.HelloInf;
import com.fengjing.framework.spring.jax.ws.User;


public class HelloImpl implements HelloInf{

    public String sayHello(String name) {
        return "Hey! "+name.toUpperCase()+ " Welocme to JAX-WS with Spring!";
    }

	@Override
	public List<User> getAllUsers() {
		List<User> lists=new ArrayList<User>();
		Dept dept; 
		User user;
		for (int i = 1; i <= 100; i++) {
			user = new User();
			user.setName("name"+i);
			user.setAge(+i);
			user.setAddress("address"+i);
			dept=new Dept(); 
			dept.setDeptid(i);
			dept.setDeptname("deptname"+i);
			user.setDept(dept);
			lists.add(user);
		}
		return lists;
	}

	@Override
	public User print(User user) {
		return user;
	}
    
}
