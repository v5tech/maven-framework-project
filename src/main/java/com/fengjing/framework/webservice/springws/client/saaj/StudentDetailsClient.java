package com.fengjing.framework.webservice.springws.client.saaj;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

/**
 * @see http://localhost:8080/maven-framework/sws/services/studentDetails.wsdl
 * @author scott
 *
 */
public class StudentDetailsClient {

    public static final String NAMESPACE_URI = "http://www.example.org/student";

    public static final String PREFIX = "tns";

    private SOAPConnectionFactory connectionFactory;

    private MessageFactory messageFactory;

    private URL url;

    public StudentDetailsClient(String url) throws SOAPException, MalformedURLException {
        connectionFactory = SOAPConnectionFactory.newInstance();
        messageFactory = MessageFactory.newInstance();
        this.url = new URL(url);
    }

    private SOAPMessage createStudentRequest() throws SOAPException {
        SOAPMessage message = messageFactory.createMessage();
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        Name studentRequestName = envelope.createName("studentRequest", PREFIX, NAMESPACE_URI);
        SOAPBodyElement studentRequestElement = message.getSOAPBody().addBodyElement(studentRequestName);
        studentRequestElement.setValue("Hello");
        return message;
    }

    public void callWebService() throws SOAPException, IOException {
        SOAPMessage request = createStudentRequest();
        SOAPConnection connection = connectionFactory.createConnection();
        SOAPMessage response = connection.call(request, url);
        if (!response.getSOAPBody().hasFault()) {
        	writeStudentResponse(response);
        }
        else {
            SOAPFault fault = response.getSOAPBody().getFault();
            System.err.println("Received SOAP Fault");
            System.err.println("SOAP Fault Code :" + fault.getFaultCode());
            System.err.println("SOAP Fault String :" + fault.getFaultString());
        }
    }

    private void writeStudentResponse(SOAPMessage message) throws SOAPException {
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        Name echoResponseName = envelope.createName("studentResponse", PREFIX, NAMESPACE_URI);
        SOAPBodyElement echoResponseElement = (SOAPBodyElement) message.getSOAPBody().getChildElements(echoResponseName).next();
        String echoValue = echoResponseElement.getTextContent();
        System.out.println();
        System.out.println("Student Response [" + echoValue + "]");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8080/maven-framework/sws/services";
        if (args.length > 0) {
            url = args[0];
        }
        StudentDetailsClient studentDetailsClient = new StudentDetailsClient(url);
        studentDetailsClient.callWebService();
    }
}