package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.rrhh.dao.HrDncSolicitanteDao;
import net.royal.erp.rrhh.dominio.HrDncSolicitante;
import net.royal.erp.rrhh.servicio.HrDncSolicitanteServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "BeanServicioHrDncSolicitante")
public class HrDncSolicitanteServicioImpl extends GenericoServicioImpl
		implements HrDncSolicitanteServicio {

	private HrDncSolicitanteDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrDncSolicitanteServicioImpl.class);

	@Autowired
	public void setDao(HrDncSolicitanteDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer cantHrDncSolicitantePuesto(String wsbuscar1,
			String wsbuscar2, String wsbuscar3, String wsbuscar4) {
		
		return dao.cantHrDncSolicitantePuesto(wsbuscar1, wsbuscar2, wsbuscar3, wsbuscar4);
	}

	@Override
	public Integer cantHrDncSolicitanteArea(String wsbuscar1, String wsbuscar2,
			String wsbuscar3, String wsbuscar4) {
		
		return dao.cantHrDncSolicitanteArea(wsbuscar1, wsbuscar2, wsbuscar3, wsbuscar4);
	}

	@Override
	public Integer obtenerMaximoSolicitante(String iv_compania) {
		return dao.obtenerMaximoSolicitante(iv_compania);
	}

	@Override
	public Integer obtenerSecuencia(String iv_compania, String estado,
			Integer wiCurso) {
		return dao.obtenerSecuencia(iv_compania, estado, wiCurso);
	}

	@Override
	@Transactional
	public void grabarDncSolicitanteArea(String wsflagpuesto, String wsPuesto,
			String wsflagarea, String wsArea, String iv_compania,
			Integer wiSecuencia) {
		dao.grabarDncSolicitanteArea(wsflagpuesto, wsPuesto, wsflagarea, wsArea, iv_compania, wiSecuencia);
	}

	@Override
	@Transactional
	public void insertarDncSolicitante(HrDncSolicitante solicitante) {
		dao.insertarDncSolicitante(solicitante);
	}

}
