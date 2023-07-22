package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestocursosDao;
import net.royal.erp.rrhh.servicio.HrPuestocursosServicio;
import net.royal.erp.rrhh.dominio.HrPuestocursos;
import net.royal.erp.rrhh.dominio.HrPuestocursosPk;

@Service (value = "BeanServicioHrPuestocursos")
public class HrPuestocursosServicioImpl extends GenericoServicioImpl implements HrPuestocursosServicio {

	private HrPuestocursosDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestocursosServicioImpl.class);

	@Autowired
	public void setDao(HrPuestocursosDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestocursos> listarTabOtrosEstudios(Integer codigopuesto) {
		return dao.listarTabOtrosEstudios(codigopuesto);
	}

}
