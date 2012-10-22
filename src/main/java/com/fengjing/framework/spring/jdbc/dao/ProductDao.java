package com.fengjing.framework.spring.jdbc.dao;

import java.util.List;

import com.fengjing.framework.common.dao.IDao;
import com.fengjing.framework.spring.jdbc.model.Product;

public interface ProductDao extends IDao<Product> {

	List<Product> getProductListByCategory(String name);

}
