package com.fengjing.framework.hibernate.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.fengjing.framework.hibernate.dao.IDao;
import com.fengjing.framework.hibernate.model.Employee;

@Repository(value="employeeDaoHibernate4")
public class EmployeeDao implements IDao<Employee> {
	
	private SessionFactory sessionFactory;
	
	@Resource(name="hibernate4sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Object object) {
		this.sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public void delete(int id) {
		this.sessionFactory.getCurrentSession().delete(findById(id));
	}

	@Override
	public void update(Object object) {
		this.sessionFactory.getCurrentSession().update(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> query(String queryString) {
		return this.sessionFactory.getCurrentSession().createQuery(queryString).list();
	}

	@Override
	public Employee findById(int id) {
		return (Employee) this.sessionFactory.getCurrentSession().get(Employee.class, id);
	}

}
