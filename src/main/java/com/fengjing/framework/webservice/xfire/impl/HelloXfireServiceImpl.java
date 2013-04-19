package com.fengjing.framework.webservice.xfire.impl;

import com.fengjing.framework.webservice.xfire.HelloXfireService;

public class HelloXfireServiceImpl implements HelloXfireService {

	@Override
	public String sayHello(String name) {
		return "Hello, "+name;
	}

}
