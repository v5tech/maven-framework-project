package com.fengjing.framework.jaxb.unmarshaller;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.fengjing.framework.jaxb.model.ClassRoom;
import com.fengjing.framework.jaxb.model.Student;

public class JaxbUnMarshaller {
	
	@Test
	public void xml2student() throws JAXBException{
		String str="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><age>18</age><classRoom classroomid=\"classroom\" classroomname=\"三年二班\"/><stuaddress>陕西西安</stuaddress><stuname>admin</stuname></student>";
		
		JAXBContext context=JAXBContext.newInstance(Student.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Student student = (Student) unmarshaller.unmarshal(new StringReader(str));
		System.out.println(student);
	}
	
	@Test
	public void xml2classroom() throws JAXBException{
		String str="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><classRoom classroomid=\"classroom\" classroomname=\"三年二班\"><student><age>18</age><stuaddress>陕西西安</stuaddress><stuname>admin</stuname></student><student><age>18</age><stuaddress>陕西西安</stuaddress><stuname>admin</stuname></student><student><age>18</age><stuaddress>陕西西安</stuaddress><stuname>admin</stuname></student><student><age>18</age><stuaddress>陕西西安</stuaddress><stuname>admin</stuname></student><student><age>18</age><stuaddress>陕西西安</stuaddress><stuname>admin</stuname></student><student><age>18</age><stuaddress>陕西西安</stuaddress><stuname>admin</stuname></student><student><age>18</age><stuaddress>陕西西安</stuaddress><stuname>admin</stuname></student><student><age>18</age><stuaddress>陕西西安</stuaddress><stuname>admin</stuname></student><student><age>18</age><stuaddress>陕西西安</stuaddress><stuname>admin</stuname></student><student><age>18</age><stuaddress>陕西西安</stuaddress><stuname>admin</stuname></student></classRoom>";
		JAXBContext context=JAXBContext.newInstance(ClassRoom.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ClassRoom room = (ClassRoom) unmarshaller.unmarshal(new StringReader(str));
		System.out.println(room);
	}
	
}
