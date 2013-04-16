package com.fengjing.framework.spring.jax.ws.service;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.fengjing.framework.spring.jax.ws.HelloInf;
import com.fengjing.framework.spring.jax.ws.User;

/*
 * wsdlµÿ÷∑http://localhost:8080/maven-framework/service/hello?wsdl
 */

@WebService
public class Hello {
    
    private HelloInf hello;
    
    /**
     * Sample web service method to say Hello
     * @param name
     * @return 
     */
    @WebMethod(operationName="sayHello")
    public String sayHello(String name)
    {
        return "Hey! "+name.toUpperCase()+ " Welocme to JAX-WS without Spring!";
    }
    
    @WebMethod(operationName="sayHelloUsingSpring")
    public String sayHelloUsingSpring(String name)
    {
        return hello.sayHello(name);
    }
    
    
    @WebMethod(operationName="getAllUsers")
    public List<User> getAllUsers()
    {
        return hello.getAllUsers();
    }
    
    @WebMethod(operationName="print")
    public User print(User user){
    	return hello.print(user);
    }
    
    
    @WebMethod(exclude=true)
    public void setHello(HelloInf hello)
    {
        this.hello = hello;
    }
    
    
}
