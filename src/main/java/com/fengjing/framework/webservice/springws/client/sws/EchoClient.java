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
 * @see http://localhost:8080/maven-framework/sws/services/echo.wsdl
 * @author scott
 *
 */
public class EchoClient extends WebServiceGatewaySupport {

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
                new ClassPathXmlApplicationContext("applicationContext.xml", EchoClient.class);
        EchoClient echoClient = (EchoClient) applicationContext.getBean("echoClient");
        echoClient.echo();
    }

}
