package com.fengjing.framework.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fengjing.framework.mybatis.dao.ProductMapper;
import com.fengjing.framework.mybatis.model.Product;

@Service(value="myBatisProductService")
public class ProductService {
	@Autowired
	private ProductMapper productMapper;

	List<Product> getProductListByCategory(String categoryId){
		return productMapper.getProductListByCategory(categoryId);
	}

	Product getProduct(String productId){
		return productMapper.getProduct(productId);
	}

	List<Product> searchProductList(String keywords){
		return productMapper.searchProductList("%"+keywords+"%");
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	void save(Product product){
		productMapper.save(product);
	}
	
	
	
	List<Product> listAll(){
		return productMapper.listAllProduct();
	}
}
