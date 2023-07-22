package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrEvaluacionesrangoDao;
import net.royal.erp.rrhh.servicio.HrEvaluacionesrangoServicio;
import net.royal.erp.rrhh.dominio.HrEvaluacionesrango;
import net.royal.erp.rrhh.dominio.HrEvaluacionesrangoPk;

@Service (value = "BeanServicioHrEvaluacionesrango")
public class HrEvaluacionesrangoServicioImpl extends GenericoServicioImpl implements HrEvaluacionesrangoServicio {

	private HrEvaluacionesrangoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEvaluacionesrangoServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluacionesrangoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public String ObtenerEvaluacionesRango(BigDecimal desde, BigDecimal hasta) {
		return dao.ObtenerEvaluacionesRango(desde, hasta);
	}

}
