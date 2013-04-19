package com.fengjing.framework.webservice.cxf.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.fengjing.framework.webservice.cxf.HelloWorld;

@WebService(endpointInterface = "com.fengjing.framework.webservice.cxf.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@WebMethod(operationName="sayHi")
	@WebResult(name="returnValue")
    public String sayHi(@WebParam(name="name")String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }
}
