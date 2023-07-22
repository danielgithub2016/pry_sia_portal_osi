package net.royal.erp.asistencia.servicio.impl;

import java.util.List;

import net.royal.erp.asistencia.dao.AsTipohorarioDao;
import net.royal.erp.asistencia.dominio.AsTipohorario;
import net.royal.erp.asistencia.servicio.AsTipohorarioServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsTipohorario")
public class AsTipohorarioServicioImpl extends GenericoServicioImpl implements
		AsTipohorarioServicio {

	private AsTipohorarioDao dao;

	private static Log LOGGER = LogFactory
			.getLog(AsTipohorarioServicioImpl.class);

	@Autowired
	public void setDao(AsTipohorarioDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public String obtenerDescripcionLocal(Integer tipohorario) {
		// TODO Auto-generated method stub
		return dao.obtenerDescripcionLocal(tipohorario);
	}

	@Override
	public List<AsTipohorario> listarTipoHorarioOrden() {
		return dao.listarTipoHorarioOrden();
	}


}
