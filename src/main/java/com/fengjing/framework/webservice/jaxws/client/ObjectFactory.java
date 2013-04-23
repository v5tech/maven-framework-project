
package com.fengjing.framework.webservice.jaxws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fengjing.framework.webservice.jaxws.client package. 
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

    private final static QName _SayHello_QNAME = new QName("http://service.jaxws.webservice.framework.fengjing.com/", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://service.jaxws.webservice.framework.fengjing.com/", "sayHelloResponse");
    private final static QName _Print_QNAME = new QName("http://service.jaxws.webservice.framework.fengjing.com/", "print");
    private final static QName _GetAllUsers_QNAME = new QName("http://service.jaxws.webservice.framework.fengjing.com/", "getAllUsers");
    private final static QName _SayHelloUsingSpring_QNAME = new QName("http://service.jaxws.webservice.framework.fengjing.com/", "sayHelloUsingSpring");
    private final static QName _SayHelloUsingSpringResponse_QNAME = new QName("http://service.jaxws.webservice.framework.fengjing.com/", "sayHelloUsingSpringResponse");
    private final static QName _GetAllUsersResponse_QNAME = new QName("http://service.jaxws.webservice.framework.fengjing.com/", "getAllUsersResponse");
    private final static QName _PrintResponse_QNAME = new QName("http://service.jaxws.webservice.framework.fengjing.com/", "printResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fengjing.framework.webservice.jaxws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link GetAllUsersResponse }
     * 
     */
    public GetAllUsersResponse createGetAllUsersResponse() {
        return new GetAllUsersResponse();
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
     * Create an instance of {@link Dept }
     * 
     */
    public Dept createDept() {
        return new Dept();
    }

    /**
     * Create an instance of {@link Print }
     * 
     */
    public Print createPrint() {
        return new Print();
    }

    /**
     * Create an instance of {@link GetAllUsers }
     * 
     */
    public GetAllUsers createGetAllUsers() {
        return new GetAllUsers();
    }

    /**
     * Create an instance of {@link SayHelloUsingSpring }
     * 
     */
    public SayHelloUsingSpring createSayHelloUsingSpring() {
        return new SayHelloUsingSpring();
    }

    /**
     * Create an instance of {@link PrintResponse }
     * 
     */
    public PrintResponse createPrintResponse() {
        return new PrintResponse();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.webservice.framework.fengjing.com/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.webservice.framework.fengjing.com/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Print }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.webservice.framework.fengjing.com/", name = "print")
    public JAXBElement<Print> createPrint(Print value) {
        return new JAXBElement<Print>(_Print_QNAME, Print.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.webservice.framework.fengjing.com/", name = "getAllUsers")
    public JAXBElement<GetAllUsers> createGetAllUsers(GetAllUsers value) {
        return new JAXBElement<GetAllUsers>(_GetAllUsers_QNAME, GetAllUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloUsingSpring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.webservice.framework.fengjing.com/", name = "sayHelloUsingSpring")
    public JAXBElement<SayHelloUsingSpring> createSayHelloUsingSpring(SayHelloUsingSpring value) {
        return new JAXBElement<SayHelloUsingSpring>(_SayHelloUsingSpring_QNAME, SayHelloUsingSpring.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloUsingSpringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.webservice.framework.fengjing.com/", name = "sayHelloUsingSpringResponse")
    public JAXBElement<SayHelloUsingSpringResponse> createSayHelloUsingSpringResponse(SayHelloUsingSpringResponse value) {
        return new JAXBElement<SayHelloUsingSpringResponse>(_SayHelloUsingSpringResponse_QNAME, SayHelloUsingSpringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.webservice.framework.fengjing.com/", name = "getAllUsersResponse")
    public JAXBElement<GetAllUsersResponse> createGetAllUsersResponse(GetAllUsersResponse value) {
        return new JAXBElement<GetAllUsersResponse>(_GetAllUsersResponse_QNAME, GetAllUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.webservice.framework.fengjing.com/", name = "printResponse")
    public JAXBElement<PrintResponse> createPrintResponse(PrintResponse value) {
        return new JAXBElement<PrintResponse>(_PrintResponse_QNAME, PrintResponse.class, null, value);
    }

}
