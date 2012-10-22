package com.fengjing.framework.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.fengjing.framework.mybatis.model.Product;
public interface ProductMapper {
	
	  List<Product> getProductListByCategory(String categoryId);

	  Product getProduct(@Param("id")String productId);

	  List<Product> searchProductList(String keywords);
	  
	  @Insert("insert into product (name,price,description,categoryid) values (#{name},#{price},#{description},#{categoryid})")
	  void save(Product product);

	  List<Product> listAllProduct();
}
