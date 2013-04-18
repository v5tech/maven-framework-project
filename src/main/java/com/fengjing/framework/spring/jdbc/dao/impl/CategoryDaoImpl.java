package com.fengjing.framework.spring.jdbc.dao.impl;

import java.sql.Types;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fengjing.framework.spring.jdbc.dao.CategoryDao;
import com.fengjing.framework.spring.jdbc.model.Category;

@Repository(value="jdbcCategoryDaoImpl")
public class CategoryDaoImpl implements CategoryDao{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Resource(name="jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Category findById(long id) {
		return getJdbcTemplate().queryForObject("select * from category where id = ? ",new Long[]{id}, Category.class);
	}

	@Override
	public void modify(Category t) {
		getJdbcTemplate().update("update category set name =? where id =? ", new Object[]{t.getName(),t.getId()}, new int[]{Types.VARCHAR,Types.INTEGER});
	}

	@Override
	public void save(Category t) {
		getJdbcTemplate().update("insert into category(name) values(?)", new Object[]{t.getName()});
	}

	@Override
	public void deleteById(long id) {
		getJdbcTemplate().update("delete from category where id= ? ",new Object[]{id});
	}

	@Override
	public void delete(Category t) {
		
	}

	@Override
	public List<Category> listAll() {
		return getJdbcTemplate().queryForList("select * from category",Category.class);
	}

}
