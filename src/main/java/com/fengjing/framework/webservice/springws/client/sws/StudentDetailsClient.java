package com.fengjing.framework.webservice.springws.client.sws;

import java.io.IOException;
import javax.xml.transform.Source;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.xml.transform.ResourceSource;
import org.springframework.xml.transform.StringResult;

/**
 * @see http://localhost:8080/maven-framework/sws/services/studentDetails.wsdl
 * @author scott
 *
 */
public class StudentDetailsClient extends WebServiceGatewaySupport {

    private Resource request;

    public void setRequest(Resource request) {
        this.request = request;
    }

    public void echo() throws IOException {
        Source requestSource = new ResourceSource(request);
        StringResult result = new StringResult();
        getWebServiceTemplate().sendSourceAndReceiveToResult(requestSource, result);
        System.out.println();
        System.out.println(result);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml", StudentDetailsClient.class);
        StudentDetailsClient studentDetailsClient = (StudentDetailsClient) applicationContext.getBean("studentDetailsClient");
        studentDetailsClient.echo();
    }

}
