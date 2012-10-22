package com.fengjing.framework.ibatis.service;

import java.util.List;

import com.fengjing.framework.ibatis.model.Product;

public interface ProductService {
	
	List<Product> listAll();
	
	boolean save(Product product);
	
	boolean update(Product product);
	
	Product getModel(int id);
	
	List<Product> selectLikeName(String name);
}
