package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrTipoevaluadorDao;
import net.royal.erp.rrhh.servicio.HrTipoevaluadorServicio;

import net.royal.erp.rrhh.dominio.HrTipoevaluador;
import net.royal.erp.rrhh.dominio.HrTipoevaluadorPk;

@Service (value = "BeanServicioHrTipoevaluador")
public class HrTipoevaluadorServicioImpl extends GenericoServicioImpl implements HrTipoevaluadorServicio {

	private HrTipoevaluadorDao dao;

	private static Log LOGGER = LogFactory.getLog(HrTipoevaluadorServicioImpl.class);

	@Autowired
	public void setDao(HrTipoevaluadorDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
