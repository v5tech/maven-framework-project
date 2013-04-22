package com.fengjing.framework.webservice.jaxws.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	
	private String name;
	private int age;
	private String address;
	
	private Dept dept;
	
	
	public User() {
	}
	
	public User(String name, int age, String address,Dept dept) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.dept = dept;
	}

	public User(String name, int age, String address) {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	
	
}
