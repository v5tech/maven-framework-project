package com.fengjing.framework.spring.jax.ws.impl;

import com.fengjing.framework.spring.jax.ws.HelloInf;


public class HelloImpl implements HelloInf{

    public String sayHello(String name) {
        return "Hey! "+name.toUpperCase()+ " Welocme to JAX-WS with Spring!";
    }
    
}
