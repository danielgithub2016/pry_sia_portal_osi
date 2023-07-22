
package net.royal.alfresco.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ws_cms", targetNamespace = "http://ws.oefa.gob.pe/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WsCms {

	
    /**
     * 
     * @param uuid
     * @param key
     * @return
     *     returns net.royal.alfresco.ws.ContenidoECMBean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "leerDocumento", targetNamespace = "http://ws.oefa.gob.pe/", className = "net.royal.alfresco.ws.LeerDocumento")
    @ResponseWrapper(localName = "leerDocumentoResponse", targetNamespace = "http://ws.oefa.gob.pe/", className = "net.royal.alfresco.ws.LeerDocumentoResponse")
    @Action(input = "http://ws.oefa.gob.pe/ws_cms/leerDocumentoRequest", output = "http://ws.oefa.gob.pe/ws_cms/leerDocumentoResponse")
    public ContenidoECMBean leerDocumento(
        @WebParam(name = "key", targetNamespace = "")
        String key,
        @WebParam(name = "UUID", targetNamespace = "")
        String uuid);

    /**
     * 
     * @param file
     * @param ruta
     * @param anteriorUUID
     * @param key
     * @param nomFile
     * @return
     *     returns net.royal.alfresco.ws.RptaWsBean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "actualizarDocumento", targetNamespace = "http://ws.oefa.gob.pe/", className = "net.royal.alfresco.ws.ActualizarDocumento")
    @ResponseWrapper(localName = "actualizarDocumentoResponse", targetNamespace = "http://ws.oefa.gob.pe/", className = "net.royal.alfresco.ws.ActualizarDocumentoResponse")
    @Action(input = "http://ws.oefa.gob.pe/ws_cms/actualizarDocumentoRequest", output = "http://ws.oefa.gob.pe/ws_cms/actualizarDocumentoResponse")
    public RptaWsBean actualizarDocumento(
        @WebParam(name = "key", targetNamespace = "")
        String key,
        @WebParam(name = "anteriorUUID", targetNamespace = "")
        String anteriorUUID,
        @WebParam(name = "nomFile", targetNamespace = "")
        String nomFile,
        @WebParam(name = "ruta", targetNamespace = "")
        String ruta,
        @WebParam(name = "file", targetNamespace = "")
        byte[] file);

    /**
     * 
     * @param file
     * @param ruta
     * @param key
     * @param nomFile
     * @return
     *     returns net.royal.alfresco.ws.RptaWsBean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "registrarDocumento", targetNamespace = "http://ws.oefa.gob.pe/", className = "net.royal.alfresco.ws.RegistrarDocumento")
    @ResponseWrapper(localName = "registrarDocumentoResponse", targetNamespace = "http://ws.oefa.gob.pe/", className = "net.royal.alfresco.ws.RegistrarDocumentoResponse")
    @Action(input = "http://ws.oefa.gob.pe/ws_cms/registrarDocumentoRequest", output = "http://ws.oefa.gob.pe/ws_cms/registrarDocumentoResponse")
    public RptaWsBean registrarDocumento(
        @WebParam(name = "key", targetNamespace = "")
        String key,
        @WebParam(name = "nomFile", targetNamespace = "")
        String nomFile,
        @WebParam(name = "ruta", targetNamespace = "")
        String ruta,
        @WebParam(name = "file", targetNamespace = "")
        byte[] file);

    /**
     * 
     * @param parametro3
     * @param parametro4
     * @param parametro1
     * @param parametro2
     * @param rutaSubCarpeta
     * @param key
     * @return
     *     returns net.royal.alfresco.ws.RptaBcBean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "busquedaContenido", targetNamespace = "http://ws.oefa.gob.pe/", className = "net.royal.alfresco.ws.BusquedaContenido")
    @ResponseWrapper(localName = "busquedaContenidoResponse", targetNamespace = "http://ws.oefa.gob.pe/", className = "net.royal.alfresco.ws.BusquedaContenidoResponse")
    @Action(input = "http://ws.oefa.gob.pe/ws_cms/busquedaContenidoRequest", output = "http://ws.oefa.gob.pe/ws_cms/busquedaContenidoResponse")
    public RptaBcBean busquedaContenido(
        @WebParam(name = "key", targetNamespace = "")
        String key,
        @WebParam(name = "rutaSubCarpeta", targetNamespace = "")
        String rutaSubCarpeta,
        @WebParam(name = "parametro1", targetNamespace = "")
        String parametro1,
        @WebParam(name = "parametro2", targetNamespace = "")
        String parametro2,
        @WebParam(name = "parametro3", targetNamespace = "")
        String parametro3,
        @WebParam(name = "parametro4", targetNamespace = "")
        String parametro4);

    /**
     * 
     * @param uuid
     * @param key
     * @return
     *     returns net.royal.alfresco.ws.RptaWsBean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarDocumento", targetNamespace = "http://ws.oefa.gob.pe/", className = "net.royal.alfresco.ws.EliminarDocumento")
    @ResponseWrapper(localName = "eliminarDocumentoResponse", targetNamespace = "http://ws.oefa.gob.pe/", className = "net.royal.alfresco.ws.EliminarDocumentoResponse")
    @Action(input = "http://ws.oefa.gob.pe/ws_cms/eliminarDocumentoRequest", output = "http://ws.oefa.gob.pe/ws_cms/eliminarDocumentoResponse")
    public RptaWsBean eliminarDocumento(
        @WebParam(name = "key", targetNamespace = "")
        String key,
        @WebParam(name = "UUID", targetNamespace = "")
        String uuid);

}