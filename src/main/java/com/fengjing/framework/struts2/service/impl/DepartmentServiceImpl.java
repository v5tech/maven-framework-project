package com.fengjing.framework.struts2.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fengjing.framework.struts2.dao.DepartmentDao;
import com.fengjing.framework.struts2.model.Department;
import com.fengjing.framework.struts2.service.DepartmentService;

@Service(value="departmentServiceImpl")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Resource(name="departmentDaoImpl")
	private DepartmentDao departmentDao;
	
	@Transactional
	@Override
	public Department findById(long id) {
		return departmentDao.findById(id);
	}

	@Transactional
	@Override
	public void modify(Department t) {
		departmentDao.modify(t);
	}

	@Transactional
	@Override
	public void save(Department t) {
		departmentDao.save(t);
	}

	@Transactional
	@Override
	public void deleteById(long id) {
		departmentDao.deleteById(id);
	}

	@Transactional
	@Override
	public void delete(Department t) {
		departmentDao.delete(t);
	}

	@Transactional
	@Override
	public List<Department> listAll() {
		return departmentDao.listAll();
	}

}
