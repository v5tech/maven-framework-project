package com.fengjing.framework.jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="classRoom")
public class ClassRoom {
	
	private String classroomid;
	private String classroomname;
	
	private List<Student> students;
	
	public ClassRoom() {
	}
	
	public ClassRoom(String classroomid, String classroomname) {
		super();
		this.classroomid = classroomid;
		this.classroomname = classroomname;
	}




	public ClassRoom(String classroomid, String classroomname,
			List<Student> students) {
		super();
		this.classroomid = classroomid;
		this.classroomname = classroomname;
		this.students = students;
	}



	public String getClassroomid() {
		return classroomid;
	}
	@XmlAttribute
	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}
	public String getClassroomname() {
		return classroomname;
	}
	@XmlAttribute
	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}
	public List<Student> getStudents() {
		return students;
	}
	@XmlElement(name="student")
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "ClassRoom [classroomid=" + classroomid + ", classroomname="
				+ classroomname +"]";
	}
	
	
	
}
