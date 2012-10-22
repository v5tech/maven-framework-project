package com.fengjing.framework.springmvc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="contacts")
public class Contacts {
	
	private List<Contact> contacts;

	@XmlElement(name="contact")
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	
	
}
