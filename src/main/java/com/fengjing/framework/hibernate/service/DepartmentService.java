package com.fengjing.framework.hibernate.service;

import java.util.List;

import com.fengjing.framework.hibernate.model.Department;

public interface DepartmentService {
	public void add(Object object);
	public void delete(int id);
	public void update(Object object);
	public List<Department> query(String queryString);
}
