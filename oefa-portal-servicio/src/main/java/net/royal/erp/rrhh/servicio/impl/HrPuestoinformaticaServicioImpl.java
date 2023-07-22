package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestoinformaticaDao;
import net.royal.erp.rrhh.servicio.HrPuestoinformaticaServicio;
import net.royal.erp.rrhh.dominio.HrPuestoinformatica;
import net.royal.erp.rrhh.dominio.HrPuestoinformaticaPk;

@Service (value = "BeanServicioHrPuestoinformatica")
public class HrPuestoinformaticaServicioImpl extends GenericoServicioImpl implements HrPuestoinformaticaServicio {

	private HrPuestoinformaticaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoinformaticaServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoinformaticaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestoinformatica> listarPuestosInformaticas(
			Integer codigopuesto) {
		return dao.listarPuestosInformaticas(codigopuesto);
	}

}
