package com.fengjing.framework.spring.jdbc.dao.impl;

import java.sql.Types;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.fengjing.framework.spring.jdbc.dao.CategoryDao;
import com.fengjing.framework.spring.jdbc.model.Category;

@Repository(value="jdbcCategoryDaoImpl")
public class CategoryDaoImpl extends JdbcDaoSupport implements CategoryDao{

	@SuppressWarnings("unused")
	private JdbcTemplate jdbcTemplates;
	
	@Resource(name="jdbcTemplate")
	public void setJdbcTemplates(JdbcTemplate jdbcTemplates) {
		super.setJdbcTemplate(jdbcTemplates);
	}

	@Override
	public Category findById(long id) {
		return super.getJdbcTemplate().queryForObject("select * from category where id = ? ",new Long[]{id}, Category.class);
	}

	@Override
	public void modify(Category t) {
		super.getJdbcTemplate().update("update category set name =? where id =? ", new Object[]{t.getName(),t.getId()}, new int[]{Types.VARCHAR,Types.INTEGER});
	}

	@Override
	public void save(Category t) {
		super.getJdbcTemplate().update("insert into category(name) values(?)", new Object[]{t.getName()});
	}

	@Override
	public void deleteById(long id) {
		super.getJdbcTemplate().update("delete from category where id= ? ",new Object[]{id});
	}

	@Override
	public void delete(Category t) {
		
	}

	@Override
	public List<Category> listAll() {
		return super.getJdbcTemplate().queryForList("select * from category",Category.class);
	}

}
