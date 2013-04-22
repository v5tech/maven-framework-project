package com.fengjing.framework.spring.remoting;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	
	private String name;
	private String password;

	public User() {
	}
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
