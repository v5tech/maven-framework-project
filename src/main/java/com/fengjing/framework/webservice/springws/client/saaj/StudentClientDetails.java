package com.fengjing.framework.webservice.springws.client.saaj;

import java.io.StringReader;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import org.junit.Test;
import org.w3c.dom.Document;

/**
 * @see http://localhost:8080/maven-framework/sws/services/studentDetails.wsdl
 * @author scott
 *
 */
public class StudentClientDetails {
	
	public static final String NAMESPACE_URI = "http://www.example.org/student";

    public static final String PREFIX = "tns";

    private URL url ;
    
    
    @Test
    public void sendRequesetBySOAPMessage() throws Exception{
    	
    	/* SOAP消息
         * <?xml version="1.0" encoding="UTF-8"?>
    	 * <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    	 * <SOAP-ENV:Header />
    	 * <SOAP-ENV:Body>
    	 * 			<tns:studentRequest xmlns:tns="http://www.example.org/student">
    	 * 				<Name>使用SpringWS发布来自契约优先的WebService</Name>
    	 * 				<Subject1>1</Subject1>
    	 * 				<Subject2>3</Subject2>
    	 * 				<Subject3>5</Subject3>
    	 * 			</tns:studentRequest>
    	 * </SOAP-ENV:Body>
    	 * </SOAP-ENV:Envelope>
         */
    	
    	/****************创建SOAP消息*********************/
    	//1、创建MessageFactory
    	MessageFactory messageFactory = MessageFactory.newInstance();
    	//2、根据MessageFactory创建SOAPMessage
    	SOAPMessage message = messageFactory.createMessage();
    	//3、根据SOAPMessage获取SOAPPart
    	SOAPPart soapPart = message.getSOAPPart();
    	//4、根据SOAPPart获取SOAPEnvelope
    	SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
    	//5、根据SOAPEnvelope获取SOAPBody
    	SOAPBody soapBody = soapEnvelope.getBody();
    	
    	//6、创建SOAP消息SOAPBodyElement
    	QName qname = new QName(NAMESPACE_URI, "studentRequest", PREFIX);
    	//7、根据QName创建SOAPBodyElement
    	SOAPBodyElement soapBodyElement = soapBody.addBodyElement(qname);
    	soapBodyElement.addChildElement("Name").setValue("使用SpringWS发布来自契约优先的WebService");
    	soapBodyElement.addChildElement("Subject1").setValue("1");
    	soapBodyElement.addChildElement("Subject2").setValue("3");
    	soapBodyElement.addChildElement("Subject3").setValue("5");
    	message.saveChanges();
    	
    	System.out.println("创建的SOAP消息体为:");
    	message.writeTo(System.out);
    	
    	
    	/****************发送SOAP消息*********************/
    	//1、创建wsdl URL地址
    	url = new URL("http://localhost:8080/maven-framework/sws/services/studentDetails.wsdl");
    	/*
    	 *2、创建Service
    	 *第一个参数为wsdl URL地址,
    	 *第二个参数WebService service的name StudentDetailsService 参见wsdl中的<wsdl:service name="StudentDetailsService"> 
    	 */
    	Service service=Service.create(url, new QName(NAMESPACE_URI, "StudentDetailsService"));
    	/*
    	 * 3、创建Dispatch
    	 * 第一个参数为portName 参见wsdl中的<wsdl:port binding="tns:StudentDetailsSoap11" name="StudentDetailsSoap11">
    	 * 第二个参数为SOAP消息是哪种类型的 这里我们使用SOAPMessage
    	 * 第三个参数是指消息正文是哪种类型的 MESSAGE provides access to entire protocol message, PAYLOAD to protocol message
    	 */
    	Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(NAMESPACE_URI,"StudentDetailsSoap11"), SOAPMessage.class, Service.Mode.MESSAGE);
    	//4、调用dispatch的invoke方法 传递上面构建的SOAPMessage发送webservice请求,返回的也是SOAPMessage
    	SOAPMessage soapMessage = dispatch.invoke(message);
    	System.out.println("\n响应的SOAP消息体为:");
    	soapMessage.writeTo(System.out);
    	
    	//解析消息
    	/*
    	 * <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    	 * 		<SOAP-ENV:Header/>
    	 * 			<SOAP-ENV:Body>
    	 * 				<ns2:studentResponse xmlns:ns2="http://www.example.org/student" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xml="http://www.w3.org/XML/1998/namespace">
    	 * 				<ns2:Name>使用SpringWS发布来自契约优先的WebService</ns2:Name>
    	 * 				<ns2:Department>MCA</ns2:Department>
    	 * 				<ns2:Subject1>1</ns2:Subject1>
    	 * 				<ns2:Subject2>3</ns2:Subject2>
    	 * 				<ns2:Subject3>5</ns2:Subject3>
    	 * 				<ns2:Total>9</ns2:Total>
    	 * 				</ns2:studentResponse>
    	 * 		</SOAP-ENV:Body>
    	 * </SOAP-ENV:Envelope>
    	 */
    	Document document = soapMessage.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
    	
    	String name = document.getElementsByTagNameNS(NAMESPACE_URI, "Name").item(0).getTextContent();
    	String department = document.getElementsByTagNameNS(NAMESPACE_URI, "Department").item(0).getTextContent();
    	String subject1 = document.getElementsByTagNameNS(NAMESPACE_URI, "Subject1").item(0).getTextContent();
    	String subject2 = document.getElementsByTagNameNS(NAMESPACE_URI, "Subject2").item(0).getTextContent();
    	String subject3 = document.getElementsByTagNameNS(NAMESPACE_URI, "Subject3").item(0).getTextContent();
    	String total = document.getElementsByTagNameNS(NAMESPACE_URI, "Total").item(0).getTextContent();
    	
    	System.out.println("\n解析后的数据:\nName:"+name+"\nDepartment:"+department+"\nSubject1:"+subject1+"\nSubject2:"+subject2+"\nSubject3:"+subject3+"\nTotal:"+total);
    	
    }
    
    
    
    /**
     * 使用PAYLOAD方式与Web服务交互SOAP消息 
     * @throws Exception
     */
    @Test
    public void sendRequesetByPAYLOAD() throws Exception{
    	//1、拼接payload
    	String payload="<tns:studentRequest xmlns:tns=\"http://www.example.org/student\"><Name>使用SpringWS发布来自契约优先的WebService</Name><Subject1>1</Subject1><Subject2>3</Subject2><Subject3>5</Subject3></tns:studentRequest>";
    	
    	//2、创建wsdl URL地址
    	url = new URL("http://localhost:8080/maven-framework/sws/services/studentDetails.wsdl");
    	/*
    	 *3、创建Service
    	 *第一个参数为wsdl URL地址,
    	 *第二个参数WebService service的name StudentDetailsService 参见wsdl中的<wsdl:service name="StudentDetailsService"> 
    	 */
    	Service service=Service.create(url, new QName(NAMESPACE_URI, "StudentDetailsService"));
    	
    	/*
    	 * 4、创建Dispatch
    	 * 第一个参数为portName 参见wsdl中的<wsdl:port binding="tns:StudentDetailsSoap11" name="StudentDetailsSoap11">
    	 * 第二个参数为SOAP消息是哪种类型的 这里我们使用Source
    	 * 第三个参数是指消息正文是哪种类型的 MESSAGE provides access to entire protocol message, PAYLOAD to protocol message
    	 */
    	Dispatch<Source> dispatch = service.createDispatch(new QName(NAMESPACE_URI,"StudentDetailsSoap11"), Source.class, Service.Mode.PAYLOAD);
    	
    	/*
    	 * 5、发送消息dispatch.invoke(new StreamSource(new StringReader(payload)));
    	 */
    	Source source = dispatch.invoke(new StreamSource(new StringReader(payload)));
    	
    	System.out.println("以Source方式拼接的消息为:"+payload);
    	
    	
    	System.out.println("********************解析消息体*********************");
    	//1、创建DOMResult
    	DOMResult domResult = new DOMResult();  
    	//2、将source转化为domResult
    	TransformerFactory.newInstance().newTransformer().transform(source, domResult);
    	//3、获取节点 强制转化为Document 获取数据
    	Document document = (Document) domResult.getNode();
    	String name = document.getElementsByTagNameNS(NAMESPACE_URI, "Name").item(0).getTextContent();
    	String department = document.getElementsByTagNameNS(NAMESPACE_URI, "Department").item(0).getTextContent();
    	String subject1 = document.getElementsByTagNameNS(NAMESPACE_URI, "Subject1").item(0).getTextContent();
    	String subject2 = document.getElementsByTagNameNS(NAMESPACE_URI, "Subject2").item(0).getTextContent();
    	String subject3 = document.getElementsByTagNameNS(NAMESPACE_URI, "Subject3").item(0).getTextContent();
    	String total = document.getElementsByTagNameNS(NAMESPACE_URI, "Total").item(0).getTextContent();
    	
    	System.out.println("\n解析后的数据:\nName:"+name+"\nDepartment:"+department+"\nSubject1:"+subject1+"\nSubject2:"+subject2+"\nSubject3:"+subject3+"\nTotal:"+total);
    }
    
	
}
