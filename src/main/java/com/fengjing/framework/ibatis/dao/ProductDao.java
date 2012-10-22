package com.fengjing.framework.ibatis.dao;

import java.util.List;

import com.fengjing.framework.ibatis.model.Product;

public interface ProductDao {
	
	List<Product> listAll();

	List<Product> selectLikeName(String name);
	
	boolean save(Product product);
	
	boolean update(Product product);
	
	Product getModel(int id);
}
