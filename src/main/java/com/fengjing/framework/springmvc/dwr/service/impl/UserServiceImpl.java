package com.fengjing.framework.springmvc.dwr.service.impl;

import java.util.List;


import com.fengjing.framework.springmvc.dwr.dao.UserDao;
import com.fengjing.framework.springmvc.dwr.model.User;
import com.fengjing.framework.springmvc.dwr.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean checkUsernameIsExists(String username) {
		return userDao.checkUsernameIsExists(username);
	}

	@Override
	public String getUsername(long id) {
		return userDao.getUsername(id);
	}

	@Override
	public User findUserById(long id) {
		return userDao.findUserById(id);
	}

	@Override
	public List<User> listAll() {
		return userDao.listAll();
	}

}
