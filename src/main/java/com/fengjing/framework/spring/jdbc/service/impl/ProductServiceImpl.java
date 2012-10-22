package com.fengjing.framework.spring.jdbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fengjing.framework.spring.jdbc.dao.ProductDao;
import com.fengjing.framework.spring.jdbc.model.Product;
import com.fengjing.framework.spring.jdbc.service.ProductService;

@Service(value="jdbcProductServiceImpl")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Resource(name="jdbcProductDaoImpl")
	private ProductDao productDao;
	
	@Override
	@Transactional
	public Product findById(long id) {
		return productDao.findById(id);
	}

	@Override
	@Transactional
	public void modify(Product t) {
		productDao.modify(t);
	}

	@Override
	@Transactional
	public void save(Product t) {
		productDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		productDao.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Product t) {
		productDao.delete(t);
	}

	@Override
	@Transactional
	public List<Product> listAll() {
		return productDao.listAll();
	}

	@Override
	public List<Product> getProductListByCategory(String name) {
		return productDao.getProductListByCategory(name);
	}

}
