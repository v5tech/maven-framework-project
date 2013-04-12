package com.fengjing.framework.spring.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fengjing.framework.spring.security.dao.UserDao;
import com.fengjing.framework.spring.security.model.User;
import com.fengjing.framework.spring.security.service.UserService;

@Service("securityUserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

}
