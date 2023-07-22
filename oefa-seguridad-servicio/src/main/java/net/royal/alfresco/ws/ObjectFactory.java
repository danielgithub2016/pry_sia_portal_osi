
package net.royal.alfresco.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.royal.alfresco.ws package. 
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

    private final static QName _BusquedaContenido_QNAME = new QName("http://ws.oefa.gob.pe/", "busquedaContenido");
    private final static QName _RegistrarDocumentoResponse_QNAME = new QName("http://ws.oefa.gob.pe/", "registrarDocumentoResponse");
    private final static QName _ActualizarDocumento_QNAME = new QName("http://ws.oefa.gob.pe/", "actualizarDocumento");
    private final static QName _LeerDocumento_QNAME = new QName("http://ws.oefa.gob.pe/", "leerDocumento");
    private final static QName _EliminarDocumento_QNAME = new QName("http://ws.oefa.gob.pe/", "eliminarDocumento");
    private final static QName _EliminarDocumentoResponse_QNAME = new QName("http://ws.oefa.gob.pe/", "eliminarDocumentoResponse");
    private final static QName _LeerDocumentoResponse_QNAME = new QName("http://ws.oefa.gob.pe/", "leerDocumentoResponse");
    private final static QName _BusquedaContenidoResponse_QNAME = new QName("http://ws.oefa.gob.pe/", "busquedaContenidoResponse");
    private final static QName _RegistrarDocumento_QNAME = new QName("http://ws.oefa.gob.pe/", "registrarDocumento");
    private final static QName _ActualizarDocumentoResponse_QNAME = new QName("http://ws.oefa.gob.pe/", "actualizarDocumentoResponse");
    private final static QName _ActualizarDocumentoFile_QNAME = new QName("", "file");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.royal.alfresco.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistrarDocumento }
     * 
     */
    public RegistrarDocumento createRegistrarDocumento() {
        return new RegistrarDocumento();
    }

    /**
     * Create an instance of {@link ActualizarDocumentoResponse }
     * 
     */
    public ActualizarDocumentoResponse createActualizarDocumentoResponse() {
        return new ActualizarDocumentoResponse();
    }

    /**
     * Create an instance of {@link LeerDocumentoResponse }
     * 
     */
    public LeerDocumentoResponse createLeerDocumentoResponse() {
        return new LeerDocumentoResponse();
    }

    /**
     * Create an instance of {@link EliminarDocumentoResponse }
     * 
     */
    public EliminarDocumentoResponse createEliminarDocumentoResponse() {
        return new EliminarDocumentoResponse();
    }

    /**
     * Create an instance of {@link BusquedaContenidoResponse }
     * 
     */
    public BusquedaContenidoResponse createBusquedaContenidoResponse() {
        return new BusquedaContenidoResponse();
    }

    /**
     * Create an instance of {@link EliminarDocumento }
     * 
     */
    public EliminarDocumento createEliminarDocumento() {
        return new EliminarDocumento();
    }

    /**
     * Create an instance of {@link LeerDocumento }
     * 
     */
    public LeerDocumento createLeerDocumento() {
        return new LeerDocumento();
    }

    /**
     * Create an instance of {@link ActualizarDocumento }
     * 
     */
    public ActualizarDocumento createActualizarDocumento() {
        return new ActualizarDocumento();
    }

    /**
     * Create an instance of {@link BusquedaContenido }
     * 
     */
    public BusquedaContenido createBusquedaContenido() {
        return new BusquedaContenido();
    }

    /**
     * Create an instance of {@link RegistrarDocumentoResponse }
     * 
     */
    public RegistrarDocumentoResponse createRegistrarDocumentoResponse() {
        return new RegistrarDocumentoResponse();
    }

    /**
     * Create an instance of {@link ContenidoECMBean }
     * 
     */
    public ContenidoECMBean createContenidoECMBean() {
        return new ContenidoECMBean();
    }

    /**
     * Create an instance of {@link RptaWsBean }
     * 
     */
    public RptaWsBean createRptaWsBean() {
        return new RptaWsBean();
    }

    /**
     * Create an instance of {@link RptaBcBean }
     * 
     */
    public RptaBcBean createRptaBcBean() {
        return new RptaBcBean();
    }

    /**
     * Create an instance of {@link BeanFile }
     * 
     */
    public BeanFile createBeanFile() {
        return new BeanFile();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusquedaContenido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.oefa.gob.pe/", name = "busquedaContenido")
    public JAXBElement<BusquedaContenido> createBusquedaContenido(BusquedaContenido value) {
        return new JAXBElement<BusquedaContenido>(_BusquedaContenido_QNAME, BusquedaContenido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.oefa.gob.pe/", name = "registrarDocumentoResponse")
    public JAXBElement<RegistrarDocumentoResponse> createRegistrarDocumentoResponse(RegistrarDocumentoResponse value) {
        return new JAXBElement<RegistrarDocumentoResponse>(_RegistrarDocumentoResponse_QNAME, RegistrarDocumentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.oefa.gob.pe/", name = "actualizarDocumento")
    public JAXBElement<ActualizarDocumento> createActualizarDocumento(ActualizarDocumento value) {
        return new JAXBElement<ActualizarDocumento>(_ActualizarDocumento_QNAME, ActualizarDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.oefa.gob.pe/", name = "leerDocumento")
    public JAXBElement<LeerDocumento> createLeerDocumento(LeerDocumento value) {
        return new JAXBElement<LeerDocumento>(_LeerDocumento_QNAME, LeerDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.oefa.gob.pe/", name = "eliminarDocumento")
    public JAXBElement<EliminarDocumento> createEliminarDocumento(EliminarDocumento value) {
        return new JAXBElement<EliminarDocumento>(_EliminarDocumento_QNAME, EliminarDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.oefa.gob.pe/", name = "eliminarDocumentoResponse")
    public JAXBElement<EliminarDocumentoResponse> createEliminarDocumentoResponse(EliminarDocumentoResponse value) {
        return new JAXBElement<EliminarDocumentoResponse>(_EliminarDocumentoResponse_QNAME, EliminarDocumentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.oefa.gob.pe/", name = "leerDocumentoResponse")
    public JAXBElement<LeerDocumentoResponse> createLeerDocumentoResponse(LeerDocumentoResponse value) {
        return new JAXBElement<LeerDocumentoResponse>(_LeerDocumentoResponse_QNAME, LeerDocumentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusquedaContenidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.oefa.gob.pe/", name = "busquedaContenidoResponse")
    public JAXBElement<BusquedaContenidoResponse> createBusquedaContenidoResponse(BusquedaContenidoResponse value) {
        return new JAXBElement<BusquedaContenidoResponse>(_BusquedaContenidoResponse_QNAME, BusquedaContenidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.oefa.gob.pe/", name = "registrarDocumento")
    public JAXBElement<RegistrarDocumento> createRegistrarDocumento(RegistrarDocumento value) {
        return new JAXBElement<RegistrarDocumento>(_RegistrarDocumento_QNAME, RegistrarDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.oefa.gob.pe/", name = "actualizarDocumentoResponse")
    public JAXBElement<ActualizarDocumentoResponse> createActualizarDocumentoResponse(ActualizarDocumentoResponse value) {
        return new JAXBElement<ActualizarDocumentoResponse>(_ActualizarDocumentoResponse_QNAME, ActualizarDocumentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "file", scope = ActualizarDocumento.class)
    public JAXBElement<byte[]> createActualizarDocumentoFile(byte[] value) {
        return new JAXBElement<byte[]>(_ActualizarDocumentoFile_QNAME, byte[].class, ActualizarDocumento.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "file", scope = RegistrarDocumento.class)
    public JAXBElement<byte[]> createRegistrarDocumentoFile(byte[] value) {
        return new JAXBElement<byte[]>(_ActualizarDocumentoFile_QNAME, byte[].class, RegistrarDocumento.class, ((byte[]) value));
    }

}
