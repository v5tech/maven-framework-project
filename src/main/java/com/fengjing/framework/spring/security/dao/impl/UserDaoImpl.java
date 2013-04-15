package com.fengjing.framework.spring.security.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedSingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import com.fengjing.framework.spring.security.dao.UserDao;
import com.fengjing.framework.spring.security.model.User;

@Repository("securityUserDaoImpl")
public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name="securityjdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User findUserByUsername(String username) {
		return jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ? ", new ParameterizedSingleColumnRowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user=new User();
				user.setUserid(rs.getString(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEnabled(rs.getInt(4));
				
				user.setAuthority(findAuthority(user.getUserid()));
				
				return user;
			}
		},username);
	}

	@Override
	public List<String> findAuthority(String userid) {
		return jdbcTemplate.queryForList("SELECT authority from user_roles where USER_ID = ? ", new Object[]{userid},String.class );
	}
	
}
