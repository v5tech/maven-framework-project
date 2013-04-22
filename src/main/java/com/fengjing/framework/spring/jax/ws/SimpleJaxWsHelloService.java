package com.fengjing.framework.spring.jax.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="SimpleJaxWsHelloService",endpointInterface="com.fengjing.framework.spring.jax.ws.HelloInf")
public class SimpleJaxWsHelloService implements HelloInf{
	
	@WebMethod(operationName="sayHello")
	public String sayHello(String name) {
        return "Hey! "+name.toUpperCase()+ " Welocme to JAX-WS with Spring!";
    }

	@WebMethod(operationName="getAllUsers")
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

	@WebMethod(operationName="print")
	public User print(User user) {
		return user;
	}
	
}
