package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.dao.HrEvaluacioncapacvalorDao;
import net.royal.erp.rrhh.servicio.HrEvaluacioncapacvalorServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrEvaluacioncapacvalor")
public class HrEvaluacioncapacvalorServicioImpl extends GenericoServicioImpl
		implements HrEvaluacioncapacvalorServicio {

	private HrEvaluacioncapacvalorDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrEvaluacioncapacvalorServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluacioncapacvalorDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public String f_sql_evaluacioncapacvalor_des(Integer par_evaluacion,
			BigDecimal par_valor) {
		return dao.f_sql_evaluacioncapacvalor_des(par_evaluacion, par_valor);
	}
	
	public List listarEvaluacion(Integer par_evaluacion){
		return dao.listarEvaluacion(par_evaluacion);
	}
}
