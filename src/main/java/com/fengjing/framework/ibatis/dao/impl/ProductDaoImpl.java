package com.fengjing.framework.ibatis.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.fengjing.framework.ibatis.dao.ProductDao;
import com.fengjing.framework.ibatis.model.Product;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository(value="productDaoImpl")
public class ProductDaoImpl implements ProductDao {
	
	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
	
	//½«sqlMapClient×¢Èë
	@Resource(name="sqlMapClient")
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}


	@SuppressWarnings("unchecked")
	public List<Product> listAll() {
		try {
			return getSqlMapClient().queryForList("com.fengjing.framework.ibatis.model.Product.selectAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public boolean save(Product product) {
		try {
			Object object = getSqlMapClient().insert("com.fengjing.framework.ibatis.model.Product.save", product);
			return object==null?false:true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public boolean update(Product product) {
		try {
			int n=getSqlMapClient().update("com.fengjing.framework.ibatis.model.Product.update", product);
			return n==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	


	public Product getModel(int id) {
		try {
			return (Product) getSqlMapClient().queryForObject("com.fengjing.framework.ibatis.model.Product.selectById", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Product> selectLikeName(String name) {
		try {
			return getSqlMapClient().queryForList("com.fengjing.framework.ibatis.model.Product.selectProductLikeName",name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
