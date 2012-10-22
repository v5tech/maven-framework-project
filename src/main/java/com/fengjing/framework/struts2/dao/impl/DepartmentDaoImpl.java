package com.fengjing.framework.struts2.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fengjing.framework.struts2.dao.DepartmentDao;
import com.fengjing.framework.struts2.model.Department;

@Repository(value="departmentDaoImpl")
public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public Department findById(long id) {
		Department department=new Department();
		department.setDeptid(id);
		department.setDeptname("研发部");
		return department;
	}

	@Override
	public void modify(Department t) {
		Department department=new Department();
		department.setDeptid(t.getDeptid());
		department.setDeptname("研发部");
		System.out.println(t.getDeptid()+","+t.getDeptname());
	}

	@Override
	public void save(Department t) {
		System.out.println(t.getDeptid()+","+t.getDeptname());
	}

	@Override
	public void deleteById(long id) {
		System.out.println(id);
	}

	@Override
	public void delete(Department t) {
		System.out.println(t.getDeptid());
	}

	@Override
	public List<Department> listAll() {
		List<Department> lists=new ArrayList<Department>();
		Department department;
		for (int i = 1; i <= 50; i++) {
			department=new Department();
			department.setDeptid(i);
			department.setDeptname("研发部");
			lists.add(department);
		}
		return lists;
	}

}
