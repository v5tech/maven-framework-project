package com.fengjing.framework.spring.jdbc.service;

import java.util.List;

import com.fengjing.framework.common.service.IService;
import com.fengjing.framework.spring.jdbc.model.Product;

public interface ProductService extends IService<Product> {

	List<Product> getProductListByCategory(String string);

}
