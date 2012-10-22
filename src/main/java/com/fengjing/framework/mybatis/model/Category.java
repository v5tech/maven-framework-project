package com.fengjing.framework.mybatis.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
