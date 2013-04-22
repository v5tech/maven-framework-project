package com.fengjing.framework.spring.remoting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fengjing.framework.spring.remoting.HelloServiceClient;
import com.fengjing.framework.spring.remoting.User;

@ContextConfiguration(locations={"classpath:spring-rmi.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloServiceTest {
	
	@Autowired
	private HelloServiceClient client;
	
	@Test
	public void sayHello(){
		System.out.println(client.sayHello("zhangsan"));
	}
	
	@Test
	public void modify(){
		User user=new User("zhangsan","123456");
		client.modify(user);
	}
	
	
}
