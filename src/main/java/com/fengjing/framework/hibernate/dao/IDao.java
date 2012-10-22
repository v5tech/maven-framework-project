package com.fengjing.framework.hibernate.dao;

import java.util.List;

public interface IDao<T> {
	
	public void add(Object object);
	public void delete(int id);
	public void update(Object object);
	public List<T> query(String queryString);
	public T findById(int id);
	
}
