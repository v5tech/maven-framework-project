package com.fengjing.framework.struts2.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.fengjing.framework.struts2.model.Department;
import com.fengjing.framework.struts2.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value="departmentAction")
@SuppressWarnings("serial")
public class DepartmentAction extends ActionSupport{
	
	@Resource(name="departmentServiceImpl")
	private DepartmentService departmentService;
	
	public String listAll() throws Exception {
		List<Department> lists=departmentService.listAll();
		for (Department department : lists) {
			System.out.println(department.getDeptid()+","+department.getDeptname());
		}
		return SUCCESS;
	}
}
