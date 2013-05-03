package com.fengjing.framework.webservice.springws.client.saaj;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
    
    
    private void print(SOAPMessage message) throws SOAPException {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			
			Transformer transformer = transformerFactory.newTransformer();
			
			Source sourceContent = message.getSOAPPart().getContent();
			
			StreamResult result = new StreamResult(System.out);
			
			transformer.transform(sourceContent, result);
			
			System.out.println();
			
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
    
    
    
    
    private SOAPMessage createStudentRequest() throws SOAPException {
        SOAPMessage message = messageFactory.createMessage();
        
        //SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
       
        SOAPBody soapBody = message.getSOAPBody();
        
        QName studentRequestName = new QName(NAMESPACE_URI, "studentRequest", PREFIX);
        
        SOAPBodyElement studentRequest = soapBody.addBodyElement(studentRequestName);
        
        QName childName = new QName("Name");
        SOAPElement name = studentRequest.addChildElement(childName);
        name.addTextNode("使用SpringWS发布来自契约优先的WebService");
        
        childName = new QName("Subject1");
        SOAPElement subject1 = studentRequest.addChildElement(childName);
        subject1.addTextNode("1");

        childName = new QName("Subject2");
        SOAPElement subject2 = studentRequest.addChildElement(childName);
        subject2.addTextNode("3");
        
        childName = new QName("Subject3");
        SOAPElement subject3 = studentRequest.addChildElement(childName);
        subject3.addTextNode("5");
        
        message.saveChanges();
        
        print(message);
        
        return message;
    }

	

    public void callWebService() throws SOAPException, IOException {
        SOAPMessage request = createStudentRequest();
        SOAPConnection connection = connectionFactory.createConnection();
        SOAPMessage response = connection.call(request, url);
        if (!response.getSOAPBody().hasFault()) {
        	
        	print(response);
        	
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
        Name studentResponseName = envelope.createName("studentResponse", PREFIX, NAMESPACE_URI);
        SOAPBody soapBody =  message.getSOAPBody();
        SOAPElement studentResponse = (SOAPElement) soapBody.getChildElements(studentResponseName).next();
        
        /********************第一种方法解析***********************/
        
        NodeList nodes = studentResponse.getChildNodes();
        
        for(int i=0; i<nodes.getLength(); i++){  
            Node node = nodes.item(i);  
            String name = node.getLocalName();
            String value= node.getTextContent();
            System.out.println(name+":"+value);
        }
        
        /********************第二种方法解析***********************/   
        
        /*
        SOAPElement name = (SOAPElement) studentResponse.getChildElements(envelope.createName("Name", PREFIX, NAMESPACE_URI)).next();
        System.out.println(name.getLocalName()+":"+nme.getValue());
        
        SOAPElement department = (SOAPElement) studentResponse.getChildElements(envelope.createName("Department", PREFIX, NAMESPACE_URI)).next();
        System.out.println(department.getLocalName()+":"+department.getValue());
        
        SOAPElement subject1 = (SOAPElement) studentResponse.getChildElements(envelope.createName("Subject1", PREFIX, NAMESPACE_URI)).next();
        System.out.println(subject1.getLocalName()+":"+subject1.getValue());
        
        SOAPElement subject2 = (SOAPElement) studentResponse.getChildElements(envelope.createName("Subject2", PREFIX, NAMESPACE_URI)).next();
        System.out.println(subject2.getLocalName()+":"+subject2.getValue());
        
        SOAPElement subject3 = (SOAPElement) studentResponse.getChildElements(envelope.createName("Subject3", PREFIX, NAMESPACE_URI)).next();
        System.out.println(subject3.getLocalName()+":"+subject3.getValue());
        
        SOAPElement total = (SOAPElement) studentResponse.getChildElements(envelope.createName("Total", PREFIX, NAMESPACE_URI)).next();
        System.out.println(total.getLocalName()+":"+total.getValue());
        */
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