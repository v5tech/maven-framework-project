package com.fengjing.framework.webservice.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface HelloWorld {
	
	@WebMethod(operationName = "sayHi")
	@WebResult(name = "returnValue")
	public String sayHi(@WebParam(name = "name") String text);
	
}
