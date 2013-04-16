package com.fengjing.framework.spring.dwr;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import com.fengjing.framework.spring.dwr.model.Address;

@RemoteProxy(name="dwrService")
public class DWRService {
	
	public DWRService() {
		
	}
	@RemoteMethod
	public String sayHello(String username){
		return "Hello,"+username;
	}
	
	@RemoteMethod
	public Address getAddress() throws Exception {
		Address address = new Address();		
		address.setStreet("2245 NW Overlook Drive");
		address.setCity("Portland");
		address.setState("Oregon");
		return address;
	}
	
	@RemoteMethod
	public void printAddress() {
		System.out.println("Printing");
	}
}