package com.fengjing.framework.springmvc.dwr.dao.impl;

import java.util.ArrayList;
import java.util.List;


import com.fengjing.framework.springmvc.dwr.dao.UserDao;
import com.fengjing.framework.springmvc.dwr.model.User;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean checkUsernameIsExists(String username) {
		return true;
	}

	@Override
	public String getUsername(long id) {
		return "dwrservice";
	}

	@Override
	public User findUserById(long id) {
		return new User(1,"admin","1987-02-03","陕西西安");
	}

	public List<User> listAll(){
		List<User> lists=new ArrayList<User>();
		for (int i = 1; i <= 100; i++) {
			lists.add(new User(i,"admin"+i,"1987-02-03","陕西西安"+i));
		}
		return lists;
	}
}
