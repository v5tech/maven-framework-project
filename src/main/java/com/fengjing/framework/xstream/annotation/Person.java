package com.fengjing.framework.xstream.annotation;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @see http://xstream.codehaus.org/annotations-tutorial.html
 * @author scott
 *
 */

@XStreamAlias("person")
public class Person {
	
	private String firstname;
	private String lastname;
	@XStreamAlias("phone")
	private PhoneNumber phone;
	@XStreamAlias("fax")
	private PhoneNumber fax;
	
	public Person() {
	}
	
	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Person(String firstname, String lastname, PhoneNumber phone,
			PhoneNumber fax) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.fax = fax;
	}



	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public PhoneNumber getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	public PhoneNumber getFax() {
		return fax;
	}
	public void setFax(PhoneNumber fax) {
		this.fax = fax;
	}

	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname
				+ ", phone=" + phone.getNumber() + ", fax=" + fax.getNumber() + "]";
	}
	
	
	
	
}
