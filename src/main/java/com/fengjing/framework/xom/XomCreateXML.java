package com.fengjing.framework.xom;

import java.io.IOException;
import java.math.BigInteger;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Comment;
import nu.xom.DocType;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.ParsingException;
import nu.xom.ProcessingInstruction;
import nu.xom.Serializer;
import nu.xom.Text;

import org.junit.Test;

/**
 * @see http://www.xom.nu/tutorial.xhtml
 * 使用xom創建xml
 * @author scott
 *
 */
public class XomCreateXML {

	/**
	 * 最簡單的例子
	 */
	@Test
	public void test01() {
		Element root = new Element("root");
		root.appendChild("Hello World!");
		Document doc = new Document(root);
		String result = doc.toXML();
		System.out.println(result);
	}
	
	/**
	 * 多個節點
	 */
	@Test
	public void test02() {
		BigInteger low = BigInteger.ONE;
		BigInteger high = BigInteger.ONE;
		Element root = new Element("Fibonacci_Numbers");
		for (int i = 1; i <= 10; i++) {
			Element fibonacci = new Element("fibonacci");
			fibonacci.appendChild(low.toString());
			root.appendChild(fibonacci);

			BigInteger temp = high;
			high = high.add(low);
			low = temp;
		}
		Document doc = new Document(root);
		System.out.println(doc.toXML()); 
	}
	
	/**
	 * 格式化
	 */
	@Test
	public void test03() {
		BigInteger low  = BigInteger.ONE;
	    BigInteger high = BigInteger.ONE;      

	    Element root = new Element("Fibonacci_Numbers");  
	    for (int i = 1; i <= 10; i++) {
	        Element fibonacci = new Element("fibonacci");
	        fibonacci.appendChild(low.toString());
	        root.appendChild(fibonacci);
	        
	        BigInteger temp = high;
	        high = high.add(low);
	        low = temp;
	    }
	    Document doc = new Document(root);
	      
	    try {
	      Serializer serializer = new Serializer(System.out, "ISO-8859-1");
	      serializer.setIndent(4);
	      serializer.setMaxLength(64);
	      serializer.write(doc);  
	    }
	    catch (IOException ex) {
	       System.err.println(ex); 
	    }   
	}
	
	/**
	 * 屬性
	 */
	@Test
	public void test04() {
		BigInteger low = BigInteger.ONE;
		BigInteger high = BigInteger.ONE;

		Element root = new Element("Fibonacci_Numbers");
		for (int i = 1; i <= 10; i++) {
			Element fibonacci = new Element("fibonacci");
			fibonacci.appendChild(low.toString());
			Attribute index = new Attribute("index", String.valueOf(i));
			fibonacci.addAttribute(index);
			root.appendChild(fibonacci);

			BigInteger temp = high;
			high = high.add(low);
			low = temp;
		}
		Document doc = new Document(root);
		try {
			Serializer serializer = new Serializer(System.out, "ISO-8859-1");
			serializer.setIndent(4);
			serializer.setMaxLength(64);
			serializer.write(doc);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
	
	
	/**
	 * 聲明Document Type
	 */
	@Test
	public void test05() {
		BigInteger low = BigInteger.ONE;
		BigInteger high = BigInteger.ONE;

		Element root = new Element("Fibonacci_Numbers");
		for (int i = 1; i <= 10; i++) {
			Element fibonacci = new Element("fibonacci");
			fibonacci.appendChild(low.toString());
			Attribute index = new Attribute("index", String.valueOf(i));
			fibonacci.addAttribute(index);
			root.appendChild(fibonacci);

			BigInteger temp = high;
			high = high.add(low);
			low = temp;
		}
		Document doc = new Document(root);
		DocType doctype = new DocType("Fibonacci_Numbers", "fibonacci.dtd");
		doc.insertChild(doctype, 0);
		try {
			Serializer serializer = new Serializer(System.out, "ISO-8859-1");
			serializer.setIndent(4);
			serializer.setMaxLength(64);
			serializer.write(doc);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
	
	
	/**
	 * Create Document Type
	 */
	@Test
	public void test06() throws Exception{
		Element greeting = new Element("greeting");
		Document doc = new Document(greeting);
		String temp = "<!DOCTYPE element [\n" 
		  + "<!ELEMENT greeting (#PCDATA)>\n"
		  + "]>\n"
		  + "<root />";
		Builder builder = new Builder();
		Document tempDoc = builder.build(temp, null);
		DocType doctype = tempDoc.getDocType();
		doctype.detach();
		doc.setDocType(doctype);
		
		System.out.println(doc.toXML()); 
		
	}
	
	
	/**
	 * Create elements in namespaces
	 */
	@Test
	public void test07() throws Exception{
		BigInteger low  = BigInteger.ONE;
	      BigInteger high = BigInteger.ONE;      

	      String namespace = "http://www.w3.org/1998/Math/MathML";
	      Element root = new Element("mathml:math", namespace);  
	      for (int i = 1; i <= 10; i++) {
	        Element mrow = new Element("mathml:mrow", namespace);
	        Element mi = new Element("mathml:mi", namespace);
	        Element mo = new Element("mathml:mo", namespace);
	        Element mn = new Element("mathml:mn", namespace);
	        mrow.appendChild(mi);
	        mrow.appendChild(mo);
	        mrow.appendChild(mn);
	        root.appendChild(mrow);
	        mi.appendChild("f(" + i + ")");
	        mo.appendChild("=");
	        mn.appendChild(low.toString());
	        
	        BigInteger temp = high;
	        high = high.add(low);
	        low = temp;
	      }
	      Document doc = new Document(root);

	      try {
	        Serializer serializer = new Serializer(System.out, "ISO-8859-1");
	        serializer.setIndent(4);
	        serializer.setMaxLength(64);
	        serializer.write(doc);  
	      }
	      catch (IOException ex) {
	        System.err.println(ex); 
	      }  
		
	}
	
	
	/**
	 * prints all the nodes in a document
	 */
	@Test
	public void test08() throws Exception{
		
		String pageURL="http://localhost:8080/maven-framework/dwr/index.html";
		
		Builder builder = new Builder();

		try {
			Document doc = builder.build(pageURL);
			Element root = doc.getRootElement();
			listChildren(root, 0);
		}
		// indicates a well-formedness error
		catch (ParsingException ex) {
			System.out.println(pageURL + " is not well-formed.");
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex);
		}  
	}
	
	public static void listChildren(Node current, int depth) {
		   
	    printSpaces(depth);
	    String data = "";
	    if (current instanceof Element) {
	        Element temp = (Element) current;
	        data = ": " + temp.getQualifiedName();   
	    }
	    else if (current instanceof ProcessingInstruction) {
	        ProcessingInstruction temp = (ProcessingInstruction) current;
	        data = ": " + temp.getTarget();   
	    }
	    else if (current instanceof DocType) {
	        DocType temp = (DocType) current;
	        data = ": " + temp.getRootElementName();   
	    }
	    else if (current instanceof Text || current instanceof Comment) {
	        String value = current.getValue();
	        value = value.replace('\n', ' ').trim();
	        if (value.length() <= 20) data = ": " + value;
	        else data = ": " + current.getValue().substring(0, 17) + "...";   
	    }
	    // Attributes are never returned by getChild()
	    System.out.println(current.getClass().getName() + data);
	    for (int i = 0; i < current.getChildCount(); i++) {
	      listChildren(current.getChild(i), depth+1);
	    }
	    
	  }
	  
	  private static void printSpaces(int n) {
	    
	    for (int i = 0; i < n; i++) {
	      System.out.print(' '); 
	    }
	    
	  }
	
	
	/**
	 * find the title of a web page
	 */
	@Test
	public void test09() throws Exception{
		String pageURL="http://localhost:8080/maven-framework/dwr/index.html";
		
		Builder builder = new Builder();
		   try {
		     Document doc = builder.build(pageURL);
		     Element html = doc.getRootElement();
		     Element head = html.getFirstChildElement("head");
		     if (head == null) {
		       head = html.getFirstChildElement("head", "http://www.w3.org/1999/xhtml");
		     }
		     Element title = head.getFirstChildElement("title");  
		     if (title == null) {
		       title = head.getFirstChildElement("title", "http://www.w3.org/1999/xhtml"); 
		     }
		     System.out.println(title.getValue());
		   }
		   catch (NullPointerException ex) {
		     System.err.println(pageURL + " does not have a title.");     
		   }
		   catch (ParsingException ex) {
		     System.err.println(pageURL + " is malformed.");     
		   }
		   catch (IOException ex) {
		     System.err.println("Could not read " + pageURL); 
		   }   
	}
	
	
	
	
}
