package net.royal.erp.rrhh.servicio.impl;

import net.royal.erp.rrhh.dao.HrEncuestasujetoDao;
import net.royal.erp.rrhh.dominio.HrEncuestasujeto;
import net.royal.erp.rrhh.dominio.dto.DtoHrEncuesta;
import net.royal.erp.rrhh.servicio.HrEncuestasujetoServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrEncuestasujeto")
public class HrEncuestasujetoServicioImpl extends GenericoServicioImpl implements HrEncuestasujetoServicio {

	private HrEncuestasujetoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEncuestasujetoServicioImpl.class);

	@Autowired
	public void setDao(HrEncuestasujetoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer obtenerNuevoSujeto(Integer secuencia) {
		return dao.obtenerNuevoSujeto(secuencia);
	}

	@Override
	public void registrarSujeto(DtoHrEncuesta encuestaDto, List<HrEncuestasujeto> sujeto) {
		dao.registrarSujeto(encuestaDto, sujeto);
	}

}
