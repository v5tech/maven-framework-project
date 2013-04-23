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
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;

/**
 * @see http://localhost:8080/maven-framework/sws/services/echo.wsdl
 * @author scott
 *
 */
public class EchoClient {

    public static final String NAMESPACE_URI = "http://www.springframework.org/spring-ws/samples/echo";

    public static final String PREFIX = "tns";

    private SOAPConnectionFactory connectionFactory;

    private MessageFactory messageFactory;

    private URL url;

    public EchoClient(String url) throws SOAPException, MalformedURLException {
        connectionFactory = SOAPConnectionFactory.newInstance();
        messageFactory = MessageFactory.newInstance();
        this.url = new URL(url);
    }

    private SOAPMessage createEchoRequest() throws SOAPException {
        SOAPMessage message = messageFactory.createMessage();
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        Name echoRequestName = envelope.createName("echoRequest", PREFIX, NAMESPACE_URI);
        SOAPBodyElement echoRequestElement = message.getSOAPBody()
                .addBodyElement(echoRequestName);
        echoRequestElement.setValue("Hello");
        
        print(message);
        
        return message;
    }

    public void callWebService() throws SOAPException, IOException {
        SOAPMessage request = createEchoRequest();
        SOAPConnection connection = connectionFactory.createConnection();
        SOAPMessage response = connection.call(request, url);
        if (!response.getSOAPBody().hasFault()) {
        	print(response);
            writeEchoResponse(response);
        }
        else {
            SOAPFault fault = response.getSOAPBody().getFault();
            System.err.println("Received SOAP Fault");
            System.err.println("SOAP Fault Code :" + fault.getFaultCode());
            System.err.println("SOAP Fault String :" + fault.getFaultString());
        }
    }

    private void writeEchoResponse(SOAPMessage message) throws SOAPException {
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        Name echoResponseName = envelope.createName("echoResponse", PREFIX, NAMESPACE_URI);
        SOAPBodyElement echoResponseElement = (SOAPBodyElement) message
                .getSOAPBody().getChildElements(echoResponseName).next();
        String echoValue = echoResponseElement.getTextContent();
        System.out.println();
        System.out.println("Echo Response [" + echoValue + "]");
        System.out.println();
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
    
    
    
    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8080/maven-framework/sws/services";
        if (args.length > 0) {
            url = args[0];
        }
        EchoClient echoClient = new EchoClient(url);
        echoClient.callWebService();
    }
}