package com.fengjing.framework.webservice.jaxws.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fengjing.framework.webservice.jaxws.HelloInf;
import com.fengjing.framework.webservice.jaxws.model.Dept;
import com.fengjing.framework.webservice.jaxws.model.User;


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
