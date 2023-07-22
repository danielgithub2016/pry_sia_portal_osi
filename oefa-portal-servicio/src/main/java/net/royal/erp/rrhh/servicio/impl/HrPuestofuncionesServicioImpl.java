package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrPuestofuncionesDao;
import net.royal.erp.rrhh.dominio.HrPuestofunciones;
import net.royal.erp.rrhh.servicio.HrPuestofuncionesServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrPuestofunciones")
public class HrPuestofuncionesServicioImpl extends GenericoServicioImpl
		implements HrPuestofuncionesServicio {

	private HrPuestofuncionesDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrPuestofuncionesServicioImpl.class);

	@Autowired
	public void setDao(HrPuestofuncionesDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<HrPuestofunciones> listarFunciones(Integer par_codigopuesto) {
		return dao.listarFunciones(par_codigopuesto);
	}
}
