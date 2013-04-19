package com.fengjing.framework.webservice.cxf;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="classpath:spring-cxf-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CxfClient {
	@Resource(name="helloClient")
	HelloWorld helloWorld;
	
	@Test
	public void test(){
		System.out.println(helloWorld.sayHi("Spring"));
	}
}
