package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrCtrlentregasplantillaDao;
import net.royal.erp.rrhh.servicio.HrCtrlentregasplantillaServicio;
import net.royal.erp.rrhh.dominio.HrCtrlentregasplantilla;
import net.royal.erp.rrhh.dominio.HrCtrlentregasplantillaPk;

@Service(value = "BeanServicioHrCtrlentregasplantilla")
public class HrCtrlentregasplantillaServicioImpl extends GenericoServicioImpl
		implements HrCtrlentregasplantillaServicio {

	private HrCtrlentregasplantillaDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrCtrlentregasplantillaServicioImpl.class);

	@Autowired
	public void setDao(HrCtrlentregasplantillaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public HrCtrlentregasplantilla obtenerplantillaparam(String plantilla) {
		return dao.obtenerplantillaparam(plantilla);
	}

}
