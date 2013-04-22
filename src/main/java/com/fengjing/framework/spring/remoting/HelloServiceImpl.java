package com.fengjing.framework.spring.remoting;


public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "hello,"+name+" from Spring RMI";
	}

	@Override
	public User modify(User user) {
		System.out.println("原用户名:"+user.getName()+"密码是:"+user.getPassword());
		user.setName("admin");
		user.setPassword("111111");
		System.out.println("修改后的用户名:"+user.getName()+"密码是:"+user.getPassword());
		return user;
	}

}
