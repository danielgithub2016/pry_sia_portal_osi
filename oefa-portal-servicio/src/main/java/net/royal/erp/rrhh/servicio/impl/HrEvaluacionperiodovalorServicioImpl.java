package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.dao.HrEvaluacionperiodovalorDao;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrFactorvalorSelCore;
import net.royal.erp.rrhh.servicio.HrEvaluacionperiodovalorServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioHrEvaluacionperiodovalor")
public class HrEvaluacionperiodovalorServicioImpl extends GenericoServicioImpl implements HrEvaluacionperiodovalorServicio {

	private HrEvaluacionperiodovalorDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEvaluacionperiodovalorServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluacionperiodovalorDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
	public List<DtoDwHrFactorvalorSelCore> listarEvaluacionPeriodoEvaluar(
			BigDecimal psecuenciaeval){
		return dao.listarEvaluacionPeriodoEvaluar(psecuenciaeval);
	}

}
