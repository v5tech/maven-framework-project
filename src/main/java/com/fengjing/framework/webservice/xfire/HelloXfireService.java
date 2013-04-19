package com.fengjing.framework.webservice.xfire;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface HelloXfireService {
	
	@WebMethod(operationName="sayHello")
	@WebResult(name="returnValue")
	String sayHello(@WebParam(name="name") String name);
}
