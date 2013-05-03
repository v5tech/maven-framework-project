package com.fengjing.framework.jaxb.marshaller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import com.fengjing.framework.jaxb.model.ClassRoom;
import com.fengjing.framework.jaxb.model.Student;


public class JaxbMarshaller {
	
	@Test
	public void student2xml() throws JAXBException{
		JAXBContext context=JAXBContext.newInstance(Student.class);
		Student student=new Student("admin", 18, "陕西西安", new ClassRoom("classroom", "三年二班"));
		Marshaller marshaller = context.createMarshaller();
		//設置不輸出<?xml version="1.0" encoding="UTF-8" standalone="yes"?>信息
		//marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		marshaller.marshal(student, System.out);
	}
	
	@Test
	public void classroom2xml() throws JAXBException{
		JAXBContext context=JAXBContext.newInstance(Student.class);
		ClassRoom classRoom=new ClassRoom("classroom", "三年二班");
		Student student;
		
		List<Student> students=new ArrayList<Student>();
		
		for (int i = 1; i <= 10; i++) {
			student=new Student("admin", 18, "陕西西安");
			students.add(student);
		}
		classRoom.setStudents(students);
		
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(classRoom, System.out);
	}
}