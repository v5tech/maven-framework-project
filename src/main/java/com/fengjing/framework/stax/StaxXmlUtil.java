package com.fengjing.framework.stax;

import java.io.InputStream;  

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.stream.EventFilter;  
import javax.xml.stream.FactoryConfigurationError;  
import javax.xml.stream.XMLEventReader;  
import javax.xml.stream.XMLInputFactory;  
import javax.xml.stream.XMLOutputFactory;  
import javax.xml.stream.XMLStreamConstants;  
import javax.xml.stream.XMLStreamException;  
import javax.xml.stream.XMLStreamReader;  
import javax.xml.stream.XMLStreamWriter;  
import javax.xml.stream.events.XMLEvent;  
import javax.xml.transform.OutputKeys;  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.TransformerFactoryConfigurationError;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;  
import javax.xml.xpath.XPath;  
import javax.xml.xpath.XPathConstants;  
import javax.xml.xpath.XPathFactory;  
  
import org.junit.Test;
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.NodeList; 

/**
 * 使用Stax解析xml
 * @author scott
 *
 */
public class StaxXmlUtil {
	
	
	/**
	 * 基于光标的方式解析XML
	 */
	@Test
	public void cursorParseXML() throws Exception {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		InputStream is = StaxXmlUtil.class.getResourceAsStream("books.xml");
		XMLStreamReader reader = factory.createXMLStreamReader(is);
		while(reader.hasNext()) {
			int type = reader.next();
			//处理不同的节点类型
			//处理开始节点,如<bookstore>,<book>
			if(type == XMLStreamConstants.START_ELEMENT) {
				String name = reader.getName().toString();
				System.out.println("<" + name + ">");
				//打印<book category="COOKING">节点中的第一个属性category值"COOKING"
				if(name.equals("book")){
					System.out.println("节点属性值为" + reader.getAttributeName(0) + "=" + reader.getAttributeValue(0));
				}
				if(name.equals("title")) {
					System.out.println("书籍[" + reader.getElementText() + "]");
				}
				if(name.equals("price")) {
					System.out.println("的价格为[" + reader.getElementText() + "]");
				}
			//打印文本节点的内容,注意各xml标签中的空白部分也属于文本节点..并且文本节点是没有name的,所以不能getName
			} else if(type == XMLStreamConstants.CHARACTERS) {
				System.out.println("文本节点值=[" + reader.getText().trim() + "]");
			//处理结束节点,如</book>,</title>
			} else if(type == XMLStreamConstants.END_ELEMENT) {
				System.out.println("</" + reader.getName() + ">");
			}
		}
		//最后处理完了xml,记得关闭..但不能提前关闭,因为Stax是读一点流就解析一点的
		is.close();
	}
	
	
	/**
	 * 基于迭代模型的方式解析XML
	 */
	@Test
	public void iteratorParseXML() throws Exception {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		InputStream is = StaxXmlUtil.class.getResourceAsStream("books.xml");
		XMLEventReader reader = factory.createXMLEventReader(is);
		int iteratorNum = 0; //统计遍历的次数
		while(reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if(event.isStartElement()) {                                   //通过XMLEvent判断节点类型
				String name = event.asStartElement().getName().toString(); //通过event.asxxx转换节点
				if(name.equals("title")) {
					System.out.print("书籍[" + reader.getElementText() + "]");
				}
				if(name.equals("price")) {
					System.out.println("的价格为[" + reader.getElementText() + "]");
				}
			}
			iteratorNum++;
		}
		is.close();
		System.out.println("本次操作遍历XML的次数合计为[" + iteratorNum + "]次");
	}
	
	
	/**
	 * 基于Filter的方式解析XML
	 * @see 可以有效的过滤掉不用进行操作的节点,效率会高一些
	 */
	@Test
	public void filterParseXML() throws Exception {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		InputStream is = StaxXmlUtil.class.getResourceAsStream("books.xml");
		XMLEventReader reader = factory.createFilteredReader(factory.createXMLEventReader(is),
			new EventFilter() {
				@Override
				public boolean accept(XMLEvent event) {
					if(event.isStartElement()) {
						String name = event.asStartElement().getName().toString();
						if(name.equals("title") || name.equals("price")){
							return true; //返回true表示会显示,false表示不显示
						}
					}
					return false;
				}
			});
		int iteratorNum = 0; //统计遍历的次数
		while(reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if(event.isStartElement()) {
				String name = event.asStartElement().getName().toString();
				if(name.equals("title")) {
					System.out.print("书籍[" + reader.getElementText() + "]");
				}
				if(name.equals("price")) {
					System.out.println("的价格为[" + reader.getElementText() + "]");
				}
			}
			iteratorNum++;
		}
		is.close();
		System.out.println("本次操作遍历XML的次数合计为[" + iteratorNum + "]次");
	}
	
	
	/**
	 * 基于XPath的方式解析XML
	 */
	@Test
	public void xpathParseXML() throws Exception {
		InputStream is = StaxXmlUtil.class.getResourceAsStream("books.xml");
		//创建文档处理对象
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//通过DocumentBuilder创建doc的文档对象
		Document doc = db.parse(is);
		//创建XPath
		XPath xpath = XPathFactory.newInstance().newXPath();
		//第一个参数就是XPath表达式,第二参数就是文档..这里是查找所有属性为category="WEB"的<book>节点
		NodeList list = (NodeList)xpath.evaluate("//book[@category='WEB']", doc, XPathConstants.NODESET);
		for(int i=0; i<list.getLength(); i++) {
			Element e = (Element)list.item(i);
			//由于<book>节点下只会有一个<title>节点,所有这里是item(0)
			System.out.println(e.getElementsByTagName("title").item(0).getTextContent());
			System.out.println(e.getElementsByTagName("price").item(0).getTextContent());
		}
		is.close();
	}
	
	
	/**
	 * 使用XMLStreamWriter创建XML
	 */
	@Test
	public void xmlStreamWriterXML() throws XMLStreamException, FactoryConfigurationError {
		XMLStreamWriter xsw = XMLOutputFactory.newInstance().createXMLStreamWriter(System.out);  
        xsw.writeStartDocument("GBK","1.0");  
        
        String namespaceURI = "http://blog.csdn.net/jadyer";  
        xsw.writeStartElement("pre", "uesr", namespaceURI); //再写<pre:uesr>  
        xsw.writeStartElement("pre", "id", namespaceURI);   //再写<pre:id>  
        xsw.writeCharacters("1");                           //再写1  
        xsw.writeEndElement();                              //再写</pre:id> 
        
        xsw.writeStartElement("pre", "name", namespaceURI);   //再写<pre:name>  
        xsw.writeCharacters("admin");                         //再写admin  
        xsw.writeEndElement();  
        
        
        xsw.writeStartElement("pre", "age", namespaceURI);   //再写<pre:age>  
        xsw.writeCharacters("18");                           //再写18  
        xsw.writeEndElement();  
        
        
        xsw.writeEndElement();                              //再写</pre:uesr>  
        
        xsw.writeEndDocument(); //先写<?xml version="1.0" encoding="GBK"?>  
        
        xsw.flush();  
        xsw.close();  
	}
	
	
	/**
	 * 使用Transformer更新XML
	 */
	@Test
	public void transformerModifyXML() throws Exception, TransformerFactoryConfigurationError {
		InputStream is = StaxXmlUtil.class.getResourceAsStream("books.xml");
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = db.parse(is);
		XPath xpath = XPathFactory.newInstance().newXPath();
		//查找内容含title="Learning XML"的<book>节点
		NodeList list = (NodeList)xpath.evaluate("//book[title='Learning XML']", doc, XPathConstants.NODESET);
		//获取<price>节点,这里只有一个符合条件的<book>节点,所以写成了list.item(0)
		Element e = (Element)(((Element)list.item(0)).getElementsByTagName("price").item(0));
		e.setTextContent("333.9");
		Transformer tran = TransformerFactory.newInstance().newTransformer();
		tran.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tran.setOutputProperty(OutputKeys.INDENT, "yes"); //让<?xml version=...?>与<bookestore>节点之间换行,默认不换行
		//修改节点
		tran.transform(new DOMSource(doc), new StreamResult(System.out));
		is.close();
	}
	
	
	
}
