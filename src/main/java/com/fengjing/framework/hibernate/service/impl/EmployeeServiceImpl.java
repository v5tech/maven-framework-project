package com.fengjing.framework.hibernate.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fengjing.framework.hibernate.dao.IDao;
import com.fengjing.framework.hibernate.model.Employee;
import com.fengjing.framework.hibernate.service.EmployeeService;

@Service(value="employeeServiceImplHibernate4")
@Transactional()
public class EmployeeServiceImpl implements EmployeeService {

	private IDao<Employee> dao;
	
	@Resource(name="employeeDaoHibernate4")
	public void setDao(IDao<Employee> dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(Object object) {
		dao.add(object);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(Object object) {
		dao.update(object);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Employee> query(String queryString) {
		return dao.query(queryString);
	}

}
