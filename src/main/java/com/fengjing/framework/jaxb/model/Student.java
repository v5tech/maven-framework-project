package com.fengjing.framework.jaxb.model;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="student")
public class Student {
	
	private String stuname;
	private int age;
	private String stuaddress;
	private ClassRoom room;
	
	public Student() {
	}
	
	public Student(String stuname, int age, String stuaddress, ClassRoom room) {
		super();
		this.stuname = stuname;
		this.age = age;
		this.stuaddress = stuaddress;
		this.room = room;
	}


	public Student(String stuname, int age, String stuaddress) {
		super();
		this.stuname = stuname;
		this.age = age;
		this.stuaddress = stuaddress;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStuaddress() {
		return stuaddress;
	}

	public void setStuaddress(String stuaddress) {
		this.stuaddress = stuaddress;
	}

	public ClassRoom getRoom() {
		return room;
	}
	@XmlElementRef(name="classRoom")
	public void setRoom(ClassRoom room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Student [stuname=" + stuname + ", age=" + age + ", stuaddress="
				+ stuaddress + ", classroomid=" + room.getClassroomid() + ", classroomname=" + room.getClassroomname()+"]";
	}
	
	
	
	
}
