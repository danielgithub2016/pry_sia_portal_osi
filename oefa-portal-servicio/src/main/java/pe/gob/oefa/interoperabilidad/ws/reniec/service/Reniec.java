/**
 * Reniec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.oefa.interoperabilidad.ws.reniec.service;

public interface Reniec extends java.rmi.Remote {
    public pe.gob.oefa.interoperabilidad.ws.reniec.service.ResultadoActualizacionCredencial actualizarcredencial(pe.gob.oefa.interoperabilidad.ws.reniec.service.PeticionActualizarCredencial peticion, java.lang.String usuarioOEFA, java.lang.String ip, java.lang.String mcAddress) throws java.rmi.RemoteException;
    public java.lang.String getDatavalidate(java.lang.String dni, java.lang.String usuarioOEFA, java.lang.String ip, java.lang.String mcAddress) throws java.rmi.RemoteException;
    public pe.gob.oefa.interoperabilidad.ws.reniec.service.ResultadoConsulta consultar(pe.gob.oefa.interoperabilidad.ws.reniec.service.PeticionConsulta peticion, java.lang.String usuarioOEFA, java.lang.String ip, java.lang.String mcAddress) throws java.rmi.RemoteException;
}
