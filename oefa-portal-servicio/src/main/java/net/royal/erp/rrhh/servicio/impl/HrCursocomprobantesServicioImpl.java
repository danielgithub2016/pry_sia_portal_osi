package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrCursocomprobantesDao;
import net.royal.erp.rrhh.servicio.HrCursocomprobantesServicio;
import net.royal.erp.rrhh.dominio.HrCursocomprobantes;
import net.royal.erp.rrhh.dominio.HrCursocomprobantesPk;

@Service (value = "BeanServicioHrCursocomprobantes")
public class HrCursocomprobantesServicioImpl extends GenericoServicioImpl implements HrCursocomprobantesServicio {

	private HrCursocomprobantesDao dao;

	private static Log LOGGER = LogFactory.getLog(HrCursocomprobantesServicioImpl.class);

	@Autowired
	public void setDao(HrCursocomprobantesDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrCursocomprobantes> ListarCursosComprobantes(
			String capacitacion) {
		
		return dao.ListarCursosComprobantes(capacitacion);
	}

}
