package com.fengjing.framework.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.fengjing.framework.springmvc.model.User;

/**
 * User Spring Data Jpa
 * @author fengjing
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
	
	/**
	 * 该方法实际上是查询com.fengjing.framework.springmvc.model.User中的 @NamedQuery(name="findUserById",query=" from User a where a.id=?1 ")
	 * @see com.fengjing.framework.springmvc.model.User<br/>@NamedQuery(name="findUserById",query=" from User a where a.id=?1 ")
	 * @param id
	 * @return
	 */
	User findUserById(int id);
	
	/**
	 * 根据给定的sql语句修改用户
	 * @param username
	 * @param id
	 * @return
	 */
	@Modifying
	@Query(value="update User u set u.username=?1 where u.id=?2 ")
	int modifyById(String username,int id);
	
	/**
	 * 按用户名模糊查询
	 * @param username
	 * @return
	 */
	List<User> findByUsernameLike(String username);
	
	/**
	 * 查询id小于几的用户
	 * @param id
	 * @return
	 */
	List<User> findByIdLessThan(int id);
	
	
	/**
	 * 根据username模糊查询 并按id降序排列
	 * @param username
	 * @return
	 */
	List<User> findByUsernameLikeOrderByIdDesc(String username);
	
	
	
	/**
	 * 根基id查询  between and
	 * @param i
	 * @param j
	 * @return
	 */
	List<User> findByIdBetween(int i,int j);
	
	
	
	/**
	 * 根据部门id查询用户 注意这里的方法名findUserByDeptId 会去User类中找名为dept的属性接着去dept类里面去找id  属性之间的关联查询
	 * @param deptid
	 * @return
	 */
	@Query(value=" from User user where user.dept.id=:deptid")
	List<User> findUserByDeptId(@Param("deptid")int deptid);
	
}
