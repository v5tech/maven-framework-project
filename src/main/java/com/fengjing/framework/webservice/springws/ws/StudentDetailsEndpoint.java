package com.fengjing.framework.webservice.springws.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fengjing.framework.webservice.springws.domain.ObjectFactory;
import com.fengjing.framework.webservice.springws.domain.StudentRequestType;
import com.fengjing.framework.webservice.springws.domain.StudentResponseType;

@Endpoint
public class StudentDetailsEndpoint {

	ObjectFactory objectFactory = new ObjectFactory();

	@PayloadRoot(namespace = "http://www.example.org/student", localPart = "studentRequest")
	@ResponsePayload
	public JAXBElement<StudentResponseType> searchProjects(
			@RequestPayload StudentRequestType request) {

		try {

			StudentResponseType studentResponse = objectFactory.createStudentResponseType();
			studentResponse.setName(request.getName());
			studentResponse.setDepartment("MCA");
			studentResponse.setSubject1(request.getSubject1());
			studentResponse.setSubject2(request.getSubject2());
			studentResponse.setSubject3(request.getSubject3());
			studentResponse.setTotal(request.getSubject1()+ request.getSubject2() + request.getSubject3());
			return new JAXBElement<StudentResponseType>(
					new QName("http://www.example.org/student", "studentResponse"),
					StudentResponseType.class, studentResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
