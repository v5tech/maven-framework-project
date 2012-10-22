package com.fengjing.framework.spring.data.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fengjing.framework.spring.data.jpa.repository.UserRepository;
import com.fengjing.framework.spring.data.jpa.service.UserService;
import com.fengjing.framework.springmvc.model.User;

@Service(value="userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public User findUserById(int id) {
		return repository.findUserById(id);
	}

	@Override
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public User modifyUser(User user) {
		return repository.save(user);
	}

	@Override
	public void delete(User user) {
		repository.delete(user);
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

	@Override
	public int modifyById(String username,int id) {
		return repository.modifyById(username,id);
	}

	@Override
	public List<User> findByUsernameLike(String username) {
		return repository.findByUsernameLike("%"+username+"%");
	}

	@Override
	public List<User> findByIdLessThan(int id) {
		return repository.findByIdLessThan(id);
	}

	/**
	 * 根据username查询 并按id降序排列
	 * @param username
	 * @return
	 */
	@Override
	public List<User> findByUsernameLikeOrderByIdDesc(String username) {
		return repository.findByUsernameLikeOrderByIdDesc("%"+username+"%");
	}

	@Override
	public List<User> findByIdBetween(int i, int j) {
		return repository.findByIdBetween(i, j);
	}

	@Override
	public List<User> findUserByDeptId(int deptid) {
		return repository.findUserByDeptId(deptid);
	}


}
