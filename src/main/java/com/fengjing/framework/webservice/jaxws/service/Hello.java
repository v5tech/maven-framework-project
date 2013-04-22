package com.fengjing.framework.webservice.jaxws.service;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.fengjing.framework.webservice.jaxws.HelloInf;
import com.fengjing.framework.webservice.jaxws.model.User;

/**
 * @see http://jax-ws-commons.java.net/spring/
 * @see wsdlµÿ÷∑http://localhost:8080/maven-framework/service/hello?wsdl
 * @author scott
 *
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
    public String sayHello(@WebParam(name="name")String name)
    {
        return "Hey! "+name.toUpperCase()+ " Welocme to JAX-WS without Spring!";
    }
    
    @WebMethod(operationName="sayHelloUsingSpring")
    public String sayHelloUsingSpring(@WebParam(name="name")String name)
    {
        return hello.sayHello(name);
    }
    
    
    @WebMethod(operationName="getAllUsers")
    public List<User> getAllUsers()
    {
        return hello.getAllUsers();
    }
    
    @WebMethod(operationName="print")
    public User print(@WebParam(name="user")User user){
    	return hello.print(user);
    }
    
    
    @WebMethod(exclude=true)
    public void setHello(HelloInf hello)
    {
        this.hello = hello;
    }
    
    
}
