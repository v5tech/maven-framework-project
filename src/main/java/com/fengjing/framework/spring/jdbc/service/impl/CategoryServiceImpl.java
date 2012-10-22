package com.fengjing.framework.spring.jdbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fengjing.framework.spring.jdbc.dao.CategoryDao;
import com.fengjing.framework.spring.jdbc.model.Category;
import com.fengjing.framework.spring.jdbc.service.CategoryService;

@Service(value="jdbcCategoryServiceImpl")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Resource(name="jdbcCategoryDaoImpl")
	private CategoryDao categoryDao;
	
	@Override
	@Transactional
	public Category findById(long id) {
		return categoryDao.findById(id);
	}

	@Override
	@Transactional
	public void modify(Category t) {
		categoryDao.modify(t);
	}

	@Override
	@Transactional
	public void save(Category t) {
		categoryDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		categoryDao.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Category t) {
		categoryDao.delete(t);
	}

	@Override
	@Transactional
	public List<Category> listAll() {
		return categoryDao.listAll();
	}

}
