package com.fengjing.framework.webservice.jaxws.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dept implements Serializable{
	
	private int deptid;
	private String deptname;
	
	public Dept() {
	}
	
	public Dept(int deptid, String deptname) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
	}

	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	
}
