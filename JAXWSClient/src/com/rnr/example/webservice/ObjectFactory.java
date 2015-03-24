
package com.rnr.example.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rnr.example.webservice package. 
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

    private final static QName _Sqrt_QNAME = new QName("http://webservice.example.rnr.com/", "sqrt");
    private final static QName _SqrtResponse_QNAME = new QName("http://webservice.example.rnr.com/", "sqrtResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rnr.example.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Sqrt }
     * 
     */
    public Sqrt createSqrt() {
        return new Sqrt();
    }

    /**
     * Create an instance of {@link SqrtResponse }
     * 
     */
    public SqrtResponse createSqrtResponse() {
        return new SqrtResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sqrt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.example.rnr.com/", name = "sqrt")
    public JAXBElement<Sqrt> createSqrt(Sqrt value) {
        return new JAXBElement<Sqrt>(_Sqrt_QNAME, Sqrt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SqrtResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.example.rnr.com/", name = "sqrtResponse")
    public JAXBElement<SqrtResponse> createSqrtResponse(SqrtResponse value) {
        return new JAXBElement<SqrtResponse>(_SqrtResponse_QNAME, SqrtResponse.class, null, value);
    }

}
