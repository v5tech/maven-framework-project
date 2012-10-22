package com.fengjing.framework.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="contact",catalog="framework")
@NamedQuery(name="findById",query="select a from Contact a where a.id= ?1")
@XmlRootElement(name="contact")
public class Contact {
	
	private int id;
	
	private String firstname;
	private String lastname;
	
	private String email;
	private String telephone;
	
	private String qq;
	
	private int age;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	@NotEmpty(message="名不能为空!")
	public String getFirstname() {
		return firstname;
	}

	@XmlElement
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@NotEmpty(message="姓不能为空!")
	public String getLastname() {
		return lastname;
	}

	@XmlElement
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Email(message="不是合法的电子邮件!")
	@NotEmpty(message="电子邮件不能为空!")
	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}
	@NotEmpty(message="电话号码不能为空!")
	@Pattern(regexp="((\\d{3,4})|\\d{3,4}-)?\\d{7,8}",message="电话号码只能为数字,且不能超过11位!(010-8805784)")
	public String getTelephone() {
		return telephone;
	}

	@XmlElement
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Range(min=1,max=150,message="年龄只能在1到150之间")
	public int getAge() {
		return age;
	}

	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	@NotEmpty(message="QQ号不允许为空!")
	@Pattern(regexp="^[1-9]*[1-9][0-9]*$",message="QQ号只能为数字")
	public String getQq() {
		return qq;
	}

	@XmlElement
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	

}
