package com.fengjing.framework.struts2.model;

import java.util.Set;

public class Department {

	private long deptid;
	
	private String deptname;
	
	private Set<Employee> emps;

	public long getDeptid() {
		return deptid;
	}

	public void setDeptid(long deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public Set<Employee> getEmps() {
		return emps;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}

}
