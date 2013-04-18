package com.fengjing.framework.xstream.json;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 * @see http://xstream.codehaus.org/json-tutorial.html
 * @author scott
 *
 */
public class XStreamObject2Json {

	@Test
	public void test() {
		Product product = new Product();
		
		product.setId("123");
		product.setName("Banana");
		product.setPrice(23.00);
		
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		
        /*XStream xstream = new XStream(new JsonHierarchicalStreamDriver());*/
        
        /*XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
            public HierarchicalStreamWriter createWriter(Writer writer) {
                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
            }
        });*/
        
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("product", Product.class);
        System.out.println(xstream.toXML(product));	
	}

}
