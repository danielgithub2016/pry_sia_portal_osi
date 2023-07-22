package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestopersonaacargoDao;
import net.royal.erp.rrhh.servicio.HrPuestopersonaacargoServicio;

import net.royal.erp.rrhh.dominio.HrPuestopersonaacargo;
import net.royal.erp.rrhh.dominio.HrPuestopersonaacargoPk;

@Service (value = "BeanServicioHrPuestopersonaacargo")
public class HrPuestopersonaacargoServicioImpl extends GenericoServicioImpl implements HrPuestopersonaacargoServicio {

	private HrPuestopersonaacargoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestopersonaacargoServicioImpl.class);

	@Autowired
	public void setDao(HrPuestopersonaacargoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
