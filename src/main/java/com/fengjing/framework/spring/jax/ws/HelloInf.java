package com.fengjing.framework.spring.jax.ws;

import java.util.List;

public interface HelloInf {
    
    public String sayHello(String name);
    
    public List<User> getAllUsers();
    
    public User print(User user);
    
}
