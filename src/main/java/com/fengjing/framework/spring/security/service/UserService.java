package com.fengjing.framework.spring.security.service;

import com.fengjing.framework.spring.security.model.User;

public interface UserService {
	
	User findUserByUsername(String username);
	
}
