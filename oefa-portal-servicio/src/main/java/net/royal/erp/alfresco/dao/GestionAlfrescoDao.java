package net.royal.erp.alfresco.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import net.royal.erp.alfresco.dominio.dto.DtoDocumentoAlfresco;
import net.royal.framework.web.dao.GenericoDao;
import net.royal.framework.web.dominio.MensajeUsuario;

public interface GestionAlfrescoDao extends GenericoDao<Object, Serializable> {

	public List<DtoDocumentoAlfresco> listar(String sesion_usuario, String proceso, String idproceso)
			throws SQLException;

	public List<MensajeUsuario> registrar(String sesion_usuario, String proceso, String idproceso, String nombre,
			String uiddalfresoc, String usuario) throws SQLException;

	public List<MensajeUsuario> actualizar(String sesion_usuario, String proceso, String idproceso, String idregistro,
			String nombre, String uiddalfresoc, String usuario) throws SQLException;

	public List<MensajeUsuario> eliminar(String sesion_usuario, String proceso, String idproceso, String idregistro,
			String uiddalfresoc, String usuario) throws SQLException;

}
