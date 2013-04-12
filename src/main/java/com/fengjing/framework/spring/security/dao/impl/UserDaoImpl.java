package com.fengjing.framework.spring.security.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		return jdbcTemplate.queryForObject("select * from users where username = ? ", new ParameterizedSingleColumnRowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user=new User();
				user.setUserid(rs.getString(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEnabled(rs.getInt(4));
				return user;
			}
		},username);
	}

}
