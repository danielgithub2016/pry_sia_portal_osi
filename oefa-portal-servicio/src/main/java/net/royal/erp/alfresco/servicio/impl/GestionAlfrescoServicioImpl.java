package net.royal.erp.alfresco.servicio.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.erp.alfresco.dao.GestionAlfrescoDao;
import net.royal.erp.alfresco.dominio.dto.DtoDocumentoAlfresco;
import net.royal.erp.alfresco.servicio.GestionAlfrescoServicio;
import net.royal.erp.core.dao.ParametrosmastDao;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.framework.web.core.UFile;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeUsuario;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioAlfresco")
public class GestionAlfrescoServicioImpl extends GenericoServicioImpl implements GestionAlfrescoServicio {

	private GestionAlfrescoDao dao;
	private ParametrosmastDao parametrodao;

	private static Log LOGGER = LogFactory.getLog(GestionAlfrescoServicioImpl.class);

	@Autowired
	public void setDao(GestionAlfrescoDao dao) {
		this.dao = dao;
		this.setGenericoDao(this.dao);
	}

	@Autowired
	public void setParametroDao(ParametrosmastDao parametrodao) {
		this.parametrodao = parametrodao;
	}

	@Override
	public List<DtoDocumentoAlfresco> listar(String sesion_usuario, String proceso, String idproceso)
			throws SQLException {
		// TODO Auto-generated method stub
		return dao.listar(sesion_usuario, proceso, idproceso);
	}

	@Override
	@Transactional
	public List<MensajeUsuario> registrar(String sesion_usuario, String proceso, String idproceso, String nombre,
			String uiddalfresoc, String usuario) throws SQLException {
		// TODO Auto-generated method stub
		return dao.registrar(sesion_usuario, proceso, idproceso, nombre, uiddalfresoc, usuario);
	}

	@Transactional
	@Override
	public List<MensajeUsuario> actualizar(String sesion_usuario, String proceso, String idproceso, String idregistro,
			String nombre, String uiddalfresoc, String usuario) throws SQLException {
		// TODO Auto-generated method stub
		return dao.actualizar(sesion_usuario, proceso, idproceso, idregistro, nombre, uiddalfresoc, usuario);
	}

	@Override
	@Transactional
	public List<MensajeUsuario> eliminar(String sesion_usuario, String proceso, String idproceso, String idregistro,
			String uiddalfresoc, String usuario) throws SQLException {
		return dao.eliminar(sesion_usuario, proceso, idproceso, idregistro, uiddalfresoc, usuario);
	}


}
