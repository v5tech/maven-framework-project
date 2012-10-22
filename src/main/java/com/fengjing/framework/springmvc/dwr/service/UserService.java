package com.fengjing.framework.springmvc.dwr.service;

import java.util.List;

import com.fengjing.framework.springmvc.dwr.model.User;

public interface UserService {
	
	boolean checkUsernameIsExists(String username);
	
	String getUsername(long id);
	
	User findUserById(long id);
	
	List<User> listAll();
}
