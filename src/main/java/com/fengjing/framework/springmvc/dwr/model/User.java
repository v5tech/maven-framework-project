package com.fengjing.framework.springmvc.dwr.model;


public class User {
	private long id;
	private String username;
	private String birthday;
	private String address;
	
	public User() {
	}
	
	public User(long id, String username, String birthday, String address) {
		super();
		this.id = id;
		this.username = username;
		this.birthday = birthday;
		this.address = address;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
