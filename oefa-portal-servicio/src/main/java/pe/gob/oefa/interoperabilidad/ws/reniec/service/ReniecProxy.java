package pe.gob.oefa.interoperabilidad.ws.reniec.service;

public class ReniecProxy implements pe.gob.oefa.interoperabilidad.ws.reniec.service.Reniec {
  private String _endpoint = null;
  private pe.gob.oefa.interoperabilidad.ws.reniec.service.Reniec reniec = null;
  
  public ReniecProxy() {
    _initReniecProxy();
  }
  
  public ReniecProxy(String endpoint) {
    _endpoint = endpoint;
    _initReniecProxy();
  }
  
  private void _initReniecProxy() {
    try {
      reniec = (new pe.gob.oefa.interoperabilidad.ws.reniec.service.ReniecImplServiceLocator()).getReniecImplPort();
      if (reniec != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)reniec)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)reniec)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (reniec != null)
      ((javax.xml.rpc.Stub)reniec)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.gob.oefa.interoperabilidad.ws.reniec.service.Reniec getReniec() {
    if (reniec == null)
      _initReniecProxy();
    return reniec;
  }
  
  public pe.gob.oefa.interoperabilidad.ws.reniec.service.ResultadoActualizacionCredencial actualizarcredencial(pe.gob.oefa.interoperabilidad.ws.reniec.service.PeticionActualizarCredencial peticion, java.lang.String usuarioOEFA, java.lang.String ip, java.lang.String mcAddress) throws java.rmi.RemoteException{
    if (reniec == null)
      _initReniecProxy();
    return reniec.actualizarcredencial(peticion, usuarioOEFA, ip, mcAddress);
  }
  
  public java.lang.String getDatavalidate(java.lang.String dni, java.lang.String usuarioOEFA, java.lang.String ip, java.lang.String mcAddress) throws java.rmi.RemoteException{
    if (reniec == null)
      _initReniecProxy();
    return reniec.getDatavalidate(dni, usuarioOEFA, ip, mcAddress);
  }
  
  public pe.gob.oefa.interoperabilidad.ws.reniec.service.ResultadoConsulta consultar(pe.gob.oefa.interoperabilidad.ws.reniec.service.PeticionConsulta peticion, java.lang.String usuarioOEFA, java.lang.String ip, java.lang.String mcAddress) throws java.rmi.RemoteException{
    if (reniec == null)
      _initReniecProxy();
    return reniec.consultar(peticion, usuarioOEFA, ip, mcAddress);
  }
  
  
}