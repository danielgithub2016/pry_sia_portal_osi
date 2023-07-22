package net.royal.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.ClientemastDao;
import net.royal.seguridad.dominio.Clientemast;
import net.royal.seguridad.dominio.ClientemastPk;
import net.royal.seguridad.dominio.dto.DtoClientemast;
import net.royal.seguridad.servicio.ClientemastServicio;

@Service (value = "BeanServicioClientemastSeguridad")
public class ClientemastServicioImpl extends GenericoServicioImpl implements ClientemastServicio {

	private ClientemastDao dao;

	private static Log LOGGER = LogFactory.getLog(ClientemastServicioImpl.class);

	@Autowired
	@Qualifier("clientemastDaoImplSeguridad")
	public void setDao(ClientemastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
	@Override
	public List<DtoClientemast> listarClientesPorUsuarioActual(
			UsuarioActual usuarioActual) {
		List resultado=null;
		//	PENDIENTE
		/*resultado = dao.listarPorQuery(DtoClientemast.class,
				"ClienteMast.listarClientesPorUsuarioActual", null);*/
		return resultado;
	}
}
