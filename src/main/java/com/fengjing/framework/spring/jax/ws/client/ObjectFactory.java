
package com.fengjing.framework.spring.jax.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fengjing.framework.spring.jax.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHello_QNAME = new QName("http://service.ws.jax.spring.framework.fengjing.com/", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://service.ws.jax.spring.framework.fengjing.com/", "sayHelloResponse");
    private final static QName _SayHelloUsingSpring_QNAME = new QName("http://service.ws.jax.spring.framework.fengjing.com/", "sayHelloUsingSpring");
    private final static QName _SayHelloUsingSpringResponse_QNAME = new QName("http://service.ws.jax.spring.framework.fengjing.com/", "sayHelloUsingSpringResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fengjing.framework.spring.jax.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHelloUsingSpring }
     * 
     */
    public SayHelloUsingSpring createSayHelloUsingSpring() {
        return new SayHelloUsingSpring();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link SayHelloUsingSpringResponse }
     * 
     */
    public SayHelloUsingSpringResponse createSayHelloUsingSpringResponse() {
        return new SayHelloUsingSpringResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.jax.spring.framework.fengjing.com/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.jax.spring.framework.fengjing.com/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloUsingSpring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.jax.spring.framework.fengjing.com/", name = "sayHelloUsingSpring")
    public JAXBElement<SayHelloUsingSpring> createSayHelloUsingSpring(SayHelloUsingSpring value) {
        return new JAXBElement<SayHelloUsingSpring>(_SayHelloUsingSpring_QNAME, SayHelloUsingSpring.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloUsingSpringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.jax.spring.framework.fengjing.com/", name = "sayHelloUsingSpringResponse")
    public JAXBElement<SayHelloUsingSpringResponse> createSayHelloUsingSpringResponse(SayHelloUsingSpringResponse value) {
        return new JAXBElement<SayHelloUsingSpringResponse>(_SayHelloUsingSpringResponse_QNAME, SayHelloUsingSpringResponse.class, null, value);
    }

}
