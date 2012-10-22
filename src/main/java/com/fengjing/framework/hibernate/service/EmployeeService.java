package com.fengjing.framework.hibernate.service;

import java.util.List;

import com.fengjing.framework.hibernate.model.Employee;

public interface EmployeeService {
	public void add(Object object);
	public void delete(int id);
	public void update(Object object);
	public List<Employee> query(String queryString);
}
