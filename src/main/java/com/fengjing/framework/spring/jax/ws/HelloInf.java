package com.fengjing.framework.spring.jax.ws;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface HelloInf {
    
    public String sayHello(String name);
    
    public List<User> getAllUsers();
    
    public User print(User user);
    
}
