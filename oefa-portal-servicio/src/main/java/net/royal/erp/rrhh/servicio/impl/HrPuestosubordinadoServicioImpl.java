package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestosubordinadoDao;
import net.royal.erp.rrhh.servicio.HrPuestosubordinadoServicio;
import net.royal.erp.rrhh.dominio.HrPuestosubordinado;
import net.royal.erp.rrhh.dominio.HrPuestosubordinadoPk;

@Service (value = "BeanServicioHrPuestosubordinado")
public class HrPuestosubordinadoServicioImpl extends GenericoServicioImpl implements HrPuestosubordinadoServicio {

	private HrPuestosubordinadoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestosubordinadoServicioImpl.class);

	@Autowired
	public void setDao(HrPuestosubordinadoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestosubordinado> listarTabPuestosSubordinados(
			Integer codigopuesto) {
		return dao.listarTabPuestosSubordinados(codigopuesto);
	}

}
