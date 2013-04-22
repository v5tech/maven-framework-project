package com.fengjing.framework.webservice.jaxws;

import java.util.List;

import javax.jws.WebService;

import com.fengjing.framework.webservice.jaxws.model.User;

@WebService
public interface HelloInf {
    
    public String sayHello(String name);
    
    public List<User> getAllUsers();
    
    public User print(User user);
    
}
