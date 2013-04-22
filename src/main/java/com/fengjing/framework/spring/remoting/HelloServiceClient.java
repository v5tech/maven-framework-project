package com.fengjing.framework.spring.remoting;

public class HelloServiceClient {
	
	private HelloService helloService;

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
	
	
	public String sayHello(String name) {
		return helloService.sayHello(name);
	}
	
	public User modify(User user){
		return helloService.modify(user);
	}
	
}
