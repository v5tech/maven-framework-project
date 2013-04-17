package com.fengjing.framework.xstream.json;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 * @see http://xstream.codehaus.org/json-tutorial.html
 * @author scott
 *
 */
public class XStreamJson2Object {

	public static void main(String[] args) {
		String json = "{\"product\":{\"name\":\"Banana\",\"id\":123"
			    + ",\"price\":23.0}}";
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("product", Product.class);
		Product product = (Product)xstream.fromXML(json);
		System.out.println(product.getName());
	}

}
