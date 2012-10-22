package com.fengjing.framework.common.dao;

import java.util.List;

public interface IDao<T> {
	
	T findById(long id);
	
	void modify(T t);
	
	void save(T t);
	
	void deleteById(long id);
	
	void delete(T t);
	
	List<T> listAll();
	
}
