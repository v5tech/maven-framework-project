package com.fengjing.framework.spring.data.jpa.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fengjing.framework.springmvc.model.User;

@Transactional
public interface UserService {
	
	User findUserById(int id);
	
	User save(User user);
	
	
	/**
	 * @see com.fengjing.framework.spring.data.jpa.repository.UserRepository @Modifying
	 * @see com.fengjing.framework.spring.data.jpa.repository.UserRepository @Query(value="update User u set u.username=?1 where u.id=?2 ")
	 * @param username
	 * @param deptid
	 * @param id
	 * @return
	 */
	int modifyById(String username,int id);
	
	User modifyUser(User user);
	
	void delete(User user);
	
	void delete(int id);
	
	List<User> findByUsernameLike(String username);
	
	List<User> findByIdLessThan(int id);
	
	/**
	 * 根据username查询 并按id降序排列
	 * @param username
	 * @return
	 */
	List<User> findByUsernameLikeOrderByIdDesc(String username);
	
	
	
	List<User> findByIdBetween(int i,int j);
	
	
	
	List<User> findUserByDeptId(int deptid);
}
