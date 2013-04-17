package com.fengjing.framework.xstream.annotation;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @see http://xstream.codehaus.org/annotations-tutorial.html
 * @author scott
 *
 */

@XStreamAlias("Phonenumber")
public class PhoneNumber {
	
	private int code;
	private String number;
	
	public PhoneNumber() {
	}
	
	
	
	public PhoneNumber(int code, String number) {
		super();
		this.code = code;
		this.number = number;
	}



	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
