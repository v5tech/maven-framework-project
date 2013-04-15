package com.fengjing.framework.spring.security.dao;

import java.util.List;

import com.fengjing.framework.spring.security.model.User;

public interface UserDao{
	
	User findUserByUsername(String username);
	/**
	 * 根据userid查询角色
	 * @param userid
	 * @return
	 */
	List<String> findAuthority(String userid);
	
}
