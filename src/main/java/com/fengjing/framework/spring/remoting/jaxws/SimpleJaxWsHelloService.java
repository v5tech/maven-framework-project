package com.fengjing.framework.spring.remoting.jaxws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.fengjing.framework.webservice.jaxws.HelloInf;
import com.fengjing.framework.webservice.jaxws.model.Dept;
import com.fengjing.framework.webservice.jaxws.model.User;

@WebService(serviceName="SimpleJaxWsHelloService",endpointInterface="com.fengjing.framework.webservice.jaxws.HelloInf")
public class SimpleJaxWsHelloService implements HelloInf{
	
	@WebMethod(operationName="sayHello")
	public String sayHello(String name) {
        return "Hey! "+name.toUpperCase()+ " Welocme to SimpleJaxWebService with Spring!";
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
