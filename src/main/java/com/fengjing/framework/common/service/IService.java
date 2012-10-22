package com.fengjing.framework.common.service;

import java.util.List;

public interface IService<T> {
	
	T findById(long id);
	
	void modify(T t);
	
	void save(T t);
	
	void deleteById(long id);
	
	void delete(T t);
	
	List<T> listAll();
	
}
