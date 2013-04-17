package com.fengjing.framework.jaxb.marshaller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.fengjing.framework.jaxb.ClassRoom;
import com.fengjing.framework.jaxb.Student;


public class JaxbMarshaller {
	
	
	public static void student2xml() throws JAXBException{
		JAXBContext context=JAXBContext.newInstance(Student.class);
		Student student=new Student("admin", 18, "陕西西安", new ClassRoom("classroom", "三年二班"));
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(student, System.out);
	}
	
	
	public static void classroom2xml() throws JAXBException{
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
	
	public static void main(String[] args) throws JAXBException{
		classroom2xml();
		//student2xml();
	}
}
