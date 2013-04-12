package com.fengjing.framework.spring.security.dao;

import com.fengjing.framework.spring.security.model.User;

public interface UserDao{
	
	User findUserByUsername(String username);
	
}
