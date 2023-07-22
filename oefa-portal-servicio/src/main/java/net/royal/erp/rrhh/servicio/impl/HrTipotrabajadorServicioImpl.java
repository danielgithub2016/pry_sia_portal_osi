package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrTipotrabajadorDao;
import net.royal.erp.rrhh.dominio.HrTipotrabajador;
import net.royal.erp.rrhh.servicio.HrTipotrabajadorServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrTipotrabajador")
public class HrTipotrabajadorServicioImpl extends GenericoServicioImpl
		implements HrTipotrabajadorServicio {

	private HrTipotrabajadorDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrTipotrabajadorServicioImpl.class);

	@Autowired
	public void setDao(HrTipotrabajadorDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrTipotrabajador> listarTipoTrabajadorActivo() {
		// TODO Auto-generated method stub
		return dao.listarTipoTrabajadorActivo();
	}

}
