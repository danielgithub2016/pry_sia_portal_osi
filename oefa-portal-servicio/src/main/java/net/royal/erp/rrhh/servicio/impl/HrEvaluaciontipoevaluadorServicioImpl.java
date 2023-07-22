package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrEvaluaciontipoevaluadorDao;
import net.royal.erp.rrhh.servicio.HrEvaluaciontipoevaluadorServicio;

import net.royal.erp.rrhh.dominio.HrEvaluaciontipoevaluador;
import net.royal.erp.rrhh.dominio.HrEvaluaciontipoevaluadorPk;

@Service (value = "BeanServicioHrEvaluaciontipoevaluador")
public class HrEvaluaciontipoevaluadorServicioImpl extends GenericoServicioImpl implements HrEvaluaciontipoevaluadorServicio {

	private HrEvaluaciontipoevaluadorDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEvaluaciontipoevaluadorServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluaciontipoevaluadorDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
