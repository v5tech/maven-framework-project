package com.fengjing.framework.webservice.xfire.client;

import java.net.URL;

import org.codehaus.xfire.client.Client;
import org.junit.Test;

public class HelloXfireServiceClient {
	
	@Test
	public void test() throws Exception{
		Client client = new Client(new URL("http://localhost:8080/maven-framework/helloXfireService.ws?wsdl"));
        Object[] results = client.invoke("sayHello", new Object[] { "Spring" });
        System.out.println(results[0]);
	}
	
}
