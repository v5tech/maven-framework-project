package com.fengjing.framework.hibernate.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fengjing.framework.hibernate.dao.IDao;
import com.fengjing.framework.hibernate.model.Department;
import com.fengjing.framework.hibernate.service.DepartmentService;

@Service(value="departmentServiceImplHibernate4")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private IDao<Department> dao;
	
	@Resource(name="departmentDaoHibernate4")
	public void setDao(IDao<Department> dao) {
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
	public List<Department> query(String queryString) {
		return dao.query(queryString);
	}


}
