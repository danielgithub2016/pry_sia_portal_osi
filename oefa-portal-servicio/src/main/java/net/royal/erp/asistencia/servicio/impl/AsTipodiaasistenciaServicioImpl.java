package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.asistencia.dao.AsTipodiaasistenciaDao;
import net.royal.erp.asistencia.servicio.AsTipodiaasistenciaServicio;

import net.royal.erp.asistencia.dominio.AsTipodiaasistencia;
import net.royal.erp.asistencia.dominio.AsTipodiaasistenciaPk;

@Service(value = "BeanServicioAsTipodiaasistencia")
public class AsTipodiaasistenciaServicioImpl extends GenericoServicioImpl
		implements AsTipodiaasistenciaServicio {

	private AsTipodiaasistenciaDao dao;

	private static Log LOGGER = LogFactory
			.getLog(AsTipodiaasistenciaServicioImpl.class);

	@Autowired
	public void setDao(AsTipodiaasistenciaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<AsTipodiaasistencia> listarTipoDiaAsistencia() {
		return dao.listarTipoDiaAsistencia();
	}

}
