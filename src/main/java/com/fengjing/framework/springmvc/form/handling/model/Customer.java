package com.fengjing.framework.springmvc.form.handling.model;

public class Customer {
	
	String userName;

	String address;
	
	String password;
	
	String confirmPassword;
	
	boolean receiveNewsletter;
	
	String [] favFramework;
	
	String favNumber;
	
	String sex;
	
	String country;
	
	String javaSkills;
	
	String secretValue;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isReceiveNewsletter() {
		return receiveNewsletter;
	}

	public void setReceiveNewsletter(boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}

	public String[] getFavFramework() {
		return favFramework;
	}

	public void setFavFramework(String[] favFramework) {
		this.favFramework = favFramework;
	}

	public String getFavNumber() {
		return favNumber;
	}

	public void setFavNumber(String favNumber) {
		this.favNumber = favNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getJavaSkills() {
		return javaSkills;
	}

	public void setJavaSkills(String javaSkills) {
		this.javaSkills = javaSkills;
	}

	public String getSecretValue() {
		return secretValue;
	}

	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}
	
	
	
}
